package com.example.goodreads_finalproject.repository;

import com.example.goodreads_finalproject.entity.Role;
import com.example.goodreads_finalproject.statics.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(Roles name);

}
