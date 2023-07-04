package com.example.day26_jwt_refreshtoken.repository;

import com.example.day26_jwt_refreshtoken.entity.Role;
import com.example.day26_jwt_refreshtoken.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(Roles name);
}
