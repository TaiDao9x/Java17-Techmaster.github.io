package com.example.lab1.service;

import com.example.lab1.entity.Course;
import com.example.lab1.model.response.CourseResponse;
import com.example.lab1.repository.CourseRepository;
import com.example.lab1.statics.TypeStudy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    CourseRepository courseRepository;
    ObjectMapper objectMapper;

    public List<CourseResponse> findAllCourse() {
        return courseRepository.findAll()
                .stream()
                .map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public List<CourseResponse> findAllCourseByType(TypeStudy online) {
        return courseRepository.findAllCourseByType(online)
                .stream()
                .map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public CourseResponse findCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return objectMapper.convertValue(course, CourseResponse.class);
    }


    public List<CourseResponse> findAllCourseById(Integer id) {
        return courseRepository.findAllCourseById(id)
                .stream().map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());

    }
}
