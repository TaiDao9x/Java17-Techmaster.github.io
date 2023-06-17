package com.example.minitestspringmvc.repository;

import com.example.minitestspringmvc.entity.Product;
import com.example.minitestspringmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//
}
