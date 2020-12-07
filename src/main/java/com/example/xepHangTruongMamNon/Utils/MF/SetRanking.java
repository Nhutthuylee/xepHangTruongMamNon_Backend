package com.example.xepHangTruongMamNon.Utils.MF;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@Service
public class SetRanking {
	public class Pair<A, B> {
		public final A a;
		public final B b;

		public Pair(A a, B b) {
			this.a = a;
			this.b = b;
		}
	}

	public Pair<float[][], float[][]> myRecommender(float[][] matrix, int r, float rate, float lambda) {
		int maxIter = 1000;
		int n1 = matrix.length;
		int n2 = matrix[0].length;

		float[][] U = new float[n1][r];
		float[][] V = new float[n2][r];

		// Initialize U and V matrix
		Random rand = new Random();
		for (int i = 0; i < U.length; ++i) {
			for (int j = 0; j < U[0].length; ++j) {
				U[i][j] = rand.nextFloat() / (float) r;
			}
		}

		for (int i = 0; i < V.length; ++i) {
			for (int j = 0; j < V[0].length; ++j) {
				V[i][j] = rand.nextFloat() / (float) r;
			}
		}

		for (int iter = 0; iter < maxIter; ++iter) {

			float[][] prodMatrix = new float[n1][n2];
			for (int i = 0; i < n1; ++i) {
				for (int j = 0; j < n2; ++j) {
					for (int k = 0; k < r; ++k) {
						prodMatrix[i][j] += U[i][k] * V[j][k];
					}
				}
			}

			float[][] errorMatrix = new float[n1][n2];
			for (int i = 0; i < n1; ++i) {
				for (int j = 0; j < n2; ++j) {
					if (matrix[i][j] == -1f) {
						errorMatrix[i][j] = 0f;
					} else {
						errorMatrix[i][j] = matrix[i][j] - prodMatrix[i][j];
					}
				}
			}

			float[][] UGrad = new float[n1][r];
			for (int i = 0; i < n1; ++i) {
				for (int j = 0; j < r; ++j) {
					for (int k = 0; k < n2; ++k) {
						UGrad[i][j] += errorMatrix[i][k] * V[k][j];
					}
				}
			}

			float[][] VGrad = new float[n2][r];
			for (int i = 0; i < n2; ++i) {
				for (int j = 0; j < r; ++j) {
					for (int k = 0; k < n1; ++k) {
						VGrad[i][j] += errorMatrix[k][i] * U[k][j];
					}
				}
			}

			float[][] Un = new float[n1][r];
			for (int i = 0; i < n1; ++i) {
				for (int j = 0; j < r; ++j) {
					Un[i][j] = (1f - rate * lambda) * U[i][j] + rate * UGrad[i][j];
				}
			}

			float[][] Vn = new float[n2][r];
			for (int i = 0; i < n2; ++i) {
				for (int j = 0; j < r; ++j) {
					Vn[i][j] = (1f - rate * lambda) * V[i][j] + rate * VGrad[i][j];
				}
			}

			U = Un;
			V = Vn;
		}

		Pair<float[][], float[][]> p = new Pair<float[][], float[][]>(U, V);
		return p;
	}

	public float[][] PredictRating_2(float[][] U, float[][] V, int name) {
		int n1 = U.length;
		int n2 = V.length;
		int r = V[0].length;

		float[][] prodMatrix = new float[n1][n2];
		for (int i = 0; i < n1; ++i) {
			for (int j = 0; j < n2; ++j) {
				for (int k = 0; k < r; ++k) {
					prodMatrix[i][j] += U[i][k] * V[j][k];
				}
			}
		}
		return prodMatrix;
	}

	public HashMap<Integer, Float> sortByValue(HashMap<Integer, Float> hm) {

		List<Map.Entry<Integer, Float>> list = new LinkedList<Map.Entry<Integer, Float>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Float>>() {
			public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		HashMap<Integer, Float> temp = new LinkedHashMap<Integer, Float>();
		for (Map.Entry<Integer, Float> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	public Map<Integer, Float> Readdata(Map<Integer, ArrayList<ArrayList<Float>>> tieuchi) {
		Map<Integer, Float> rankking = new HashMap<Integer, Float>();
		Set<Integer> set = tieuchi.keySet();
		for (Integer key : set) {

			int size_n = tieuchi.get(key).size();
			float[][] matrix = new float[size_n][15];
			for (int j = 0; j < tieuchi.get(key).size(); j++) {
				for (int k = 1; k < tieuchi.get(key).get(j).size(); k++) {

					float temp = tieuchi.get(key).get(j).get(k);
					if (temp == 0) {
						matrix[j][k - 1] = -1f;
					} else {
						matrix[j][k - 1] = temp;
					}
				}

			}

			float rate = (float) 0.0001;
			float lambda = (float) 0.1;
			Pair<float[][], float[][]> kq1 = myRecommender(matrix, 3, rate, lambda);
			float[][] prodMatrix = PredictRating_2(kq1.a, kq1.b, key);
			float resutl = 0.f;

			for (int l = 0; l < size_n - 1; l++) {
				for (int m = 0; m < 15; m++) {
					resutl += prodMatrix[l][m];
				}
			}
			resutl = resutl / (size_n * 15);
			rankking.put(key, resutl);
		}
		Map<Integer, Float> hm1 = sortByValue((HashMap<Integer, Float>) rankking);
		

		return hm1;
	}

}
