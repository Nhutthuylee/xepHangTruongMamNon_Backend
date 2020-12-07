package com.example.xepHangTruongMamNon.Repository;

import java.util.List;
import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.User;
import com.example.xepHangTruongMamNon.Model.enums.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    List<User> findByDeletedAndRoleName(boolean deleted, RoleName roleName);

    boolean existsByEmail(String email);

    Optional<User> findByIdAndDeletedAndRoleName(int id, boolean deleted, RoleName roleName);

    boolean existsByEmailAndDeleted(String email, boolean deleted);
}
