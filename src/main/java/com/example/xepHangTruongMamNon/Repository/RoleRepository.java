package com.example.xepHangTruongMamNon.Repository;

import com.example.xepHangTruongMamNon.Entity.Role;
import com.example.xepHangTruongMamNon.Model.enums.RoleName;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(RoleName roleName);
}
