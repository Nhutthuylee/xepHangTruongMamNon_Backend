package com.example.xepHangTruongMamNon.Repository;

import java.util.List;
import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from comment where nursery_school_id = ?1")
    List<Comment> findByNurserySchoolId(int id);

    Optional<Comment> findById(int id);
}
