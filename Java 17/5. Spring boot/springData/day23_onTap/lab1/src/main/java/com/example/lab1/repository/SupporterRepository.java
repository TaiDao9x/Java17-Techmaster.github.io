package com.example.lab1.repository;

import com.example.lab1.entity.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupporterRepository extends JpaRepository<Supporter,Integer> {
}
