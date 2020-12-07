package com.example.xepHangTruongMamNon.Repository;

import java.util.Optional;

import com.example.xepHangTruongMamNon.Entity.JwtEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JwtRepository extends JpaRepository<JwtEntity, Integer> {
    Optional<JwtEntity> findByToken(String code);
}
