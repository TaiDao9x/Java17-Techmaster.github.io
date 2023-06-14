package com.example.day22_springsecurity_day01.repository;

import com.example.day22_springsecurity_day01.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
