package com.example.demojparelationship.repository;

import com.example.demojparelationship.dto.UserDto;
import com.example.demojparelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("""
            select new com.example.demojparelationship.dto.UserDto(u.id,u.name,u.email)
            from User u
            """)
    List<UserDto> findAllUserDto();
}