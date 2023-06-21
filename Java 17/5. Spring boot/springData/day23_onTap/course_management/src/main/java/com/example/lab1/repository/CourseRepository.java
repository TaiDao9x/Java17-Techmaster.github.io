package com.example.lab1.repository;

import com.example.lab1.entity.Course;
import com.example.lab1.entity.Supporter;
import com.example.lab1.model.response.CourseResponse;
import com.example.lab1.statics.TypeStudy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query("select c from Course c join c.topics t where t.id = ?1")
    List<Course> findByTopicId(Integer id);

    Page<Course> findByTypeStudy(Pageable pageable, String type);

    List<Course> findByTypeStudy(String type);
}
