package com.example.lab1.repository;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
