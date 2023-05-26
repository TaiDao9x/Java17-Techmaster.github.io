package com.example.demojpa.repository;

import com.example.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    // Sử dụng JPQL query
    @Query("select u from User u where u.email=:email")
    Optional<User> findByEmailUsingJPQL(@Param("email") String email);

    // Sử dụng Native query
    @Query(nativeQuery = true, value = "select * from user u where u.email=:email")
    Optional<User> findByEmailUsingNativeQuery(@Param("email") String email);

//
//    List<User> findByName(String name);
//
//    List<User> findByNameContaining(String keyword);
//
//    List<User> findByNameContainingIgnoreCase(String keyword);
//
//    List<User> findByNameStartsWith(String prefix);
//
//    Optional<User> findByNameAndEmail(String name, String email);
//
//    List<User> findByNameOrEmail(String name, String email);
//
//    long countByName(String name);
//
//    boolean existsByEmail(String email);

}
