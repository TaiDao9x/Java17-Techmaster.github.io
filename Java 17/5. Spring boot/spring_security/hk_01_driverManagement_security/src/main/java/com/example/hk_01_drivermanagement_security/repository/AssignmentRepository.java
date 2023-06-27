package com.example.hk_01_drivermanagement_security.repository;

import com.example.hk_01_drivermanagement_security.entity.Assignement;
import com.example.hk_01_drivermanagement_security.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignement, Integer> {
}
