package com.example.xepHangTruongMamNon.Repository;

import java.util.List;

import com.example.xepHangTruongMamNon.Entity.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    // @Query(value = "SELECT * from school_image order by school_image.id limit 0,
    // ?1", nativeQuery = true)
    // Image findByNurserySchoolId(int id);

    @Query(nativeQuery = true, value = "SELECT * from school_image where nursery_school_id = ?1 limit 1")
    Image findByNurserySchoolId(int id);
    @Query(nativeQuery = true, value = "SELECT * from school_image where nursery_school_id = ?1")
    List<Image> findAllByNurserySchoolId(int id);
}
