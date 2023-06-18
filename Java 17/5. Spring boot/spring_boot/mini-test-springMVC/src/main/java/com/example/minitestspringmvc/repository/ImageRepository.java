package com.example.minitestspringmvc.repository;

import com.example.minitestspringmvc.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}
