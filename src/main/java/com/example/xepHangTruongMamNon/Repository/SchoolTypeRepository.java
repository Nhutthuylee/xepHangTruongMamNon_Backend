package com.example.xepHangTruongMamNon.Repository;

import com.example.xepHangTruongMamNon.Entity.SchoolType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolTypeRepository extends CrudRepository<SchoolType, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from school_type where type_name = ?1")
    SchoolType findByName(String schoolType);
}
