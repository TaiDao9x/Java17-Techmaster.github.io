package com.example.day22_security_day1.repository;

import com.example.day22_security_day1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
