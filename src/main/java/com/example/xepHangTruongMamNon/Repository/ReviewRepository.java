package com.example.xepHangTruongMamNon.Repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    Optional<Review> findByUserIdAndNurserySchoolId(int userId, int schoolId);
}
