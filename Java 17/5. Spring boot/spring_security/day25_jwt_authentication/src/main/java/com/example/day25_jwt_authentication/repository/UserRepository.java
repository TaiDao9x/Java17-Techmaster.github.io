package com.example.day25_jwt_authentication.repository;

import com.example.day25_jwt_authentication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
