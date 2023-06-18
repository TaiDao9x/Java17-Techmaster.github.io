package com.example.minitestspringmvc.repository;

import com.example.minitestspringmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(nativeQuery = true, value = "select * from users u where u.email=?1")
    User findByEmail(String email);
}
