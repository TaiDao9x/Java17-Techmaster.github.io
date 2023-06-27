package com.example.hk_01_drivermanagement_security.repository;

import com.example.hk_01_drivermanagement_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
