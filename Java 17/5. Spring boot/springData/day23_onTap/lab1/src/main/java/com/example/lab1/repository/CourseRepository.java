package com.example.lab1.repository;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Supporter;
import com.example.lab1.model.response.CourseResponse;
import com.example.lab1.statics.TypeStudy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c from Course c where c.typeStudy=?1")
    List<Course> findAllCourseByType(TypeStudy online);
}
