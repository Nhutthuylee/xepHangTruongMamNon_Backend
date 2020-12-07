package com.example.xepHangTruongMamNon.Repository;

// import com.example.xepHangTruongMamNon.WardName;
import com.example.xepHangTruongMamNon.Entity.Ward;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends CrudRepository<Ward, Integer> {
    @Query(nativeQuery = true, value = "SELECT * from ward where ward_name = ?1")
    Ward findByName(String wardName);
}
