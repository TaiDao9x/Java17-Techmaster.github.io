package com.example.minitestspringmvc.repository;

import com.example.minitestspringmvc.entity.Order;
import com.example.minitestspringmvc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
