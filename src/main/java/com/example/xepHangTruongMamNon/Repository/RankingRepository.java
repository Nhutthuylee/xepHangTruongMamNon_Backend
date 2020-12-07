package com.example.xepHangTruongMamNon.Repository;

import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.Ranking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Integer> {
    Optional<Ranking> findByNurserySchoolId(int id);
}
