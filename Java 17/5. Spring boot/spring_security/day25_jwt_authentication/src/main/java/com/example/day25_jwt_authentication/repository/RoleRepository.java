package com.example.day25_jwt_authentication.repository;

import com.example.day25_jwt_authentication.entity.Role;
import com.example.day25_jwt_authentication.entity.User;
import com.example.day25_jwt_authentication.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(Roles name);
}
