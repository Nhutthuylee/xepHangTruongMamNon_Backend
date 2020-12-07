package com.example.xepHangTruongMamNon.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ranking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "nurserySchool_id", nullable = false)
    private NurserySchool nurserySchool;

    @Column(name = "rank")
    private int rank;

    @Column(name = "rate")
    private float rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NurserySchool getNurserySchool() {
        return nurserySchool;
    }

    public void setNurserySchool(NurserySchool nurserySchool) {
        this.nurserySchool = nurserySchool;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Ranking(int id, NurserySchool nurserySchool, int rank, float rate) {
        this.id = id;
        this.nurserySchool = nurserySchool;
        this.rank = rank;
        this.rate = rate;
    }

    public Ranking() {
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public Ranking(NurserySchool nurserySchool, int rank, float rate) {
        this.nurserySchool = nurserySchool;
        this.rank = rank;
        this.rate = rate;
    }
}
