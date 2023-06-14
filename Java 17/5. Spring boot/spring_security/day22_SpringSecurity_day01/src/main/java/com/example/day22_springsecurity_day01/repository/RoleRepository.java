package com.example.day22_springsecurity_day01.repository;

import com.example.day22_springsecurity_day01.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
