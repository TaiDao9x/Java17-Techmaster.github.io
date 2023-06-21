package com.example.courseadmin.repository;

import com.example.courseadmin.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CourseRepository extends JpaRepository<Course, Integer> {

    void removeByid(Integer id);

}
