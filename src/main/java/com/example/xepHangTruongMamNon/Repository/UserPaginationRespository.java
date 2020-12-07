package com.example.xepHangTruongMamNon.Repository;

import com.example.xepHangTruongMamNon.Entity.User;

// import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
// import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface UserPaginationRespository extends JpaRepository<User, Integer> {
    Page<User> findAllByDeleted(Pageable pageable, boolean deleted);

}
