package com.example.xepHangTruongMamNon.Repository;

import java.util.List;
import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.NurserySchool;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends PagingAndSortingRepository<NurserySchool, Integer> {
    Optional<NurserySchool> findByName(String name);

    List<NurserySchool> findByWardId(int id);
}
