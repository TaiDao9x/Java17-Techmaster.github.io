package com.example.lab1.service;

import com.example.lab1.entity.Course;
import com.example.lab1.model.response.CourseResponse;
import com.example.lab1.repository.CourseRepository;
import com.example.lab1.statics.TypeStudy;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    CourseRepository courseRepository;
    ObjectMapper objectMapper;

    public Page<CourseResponse> findAllCourse(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Course> courses = courseRepository.findAll(pageable);

        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course c : courses) {
            courseResponses.add(objectMapper.convertValue(c, CourseResponse.class));
        }

        return new PageImpl<>(courseResponses, pageable, courses.getTotalElements());
    }


    public Page<CourseResponse> findAllCourseByType(Integer page, Integer pageSize, String online) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        Page<Course> courses = courseRepository.findByTypeStudy(pageRequest, online);
        List<CourseResponse> courseResponses = new ArrayList<>();
        courses.forEach(course -> courseResponses.add(objectMapper.convertValue(course, CourseResponse.class)));

        return new PageImpl<>(courseResponses, pageRequest, courses.getTotalElements());
    }

    public List<CourseResponse> findAllCourseByType(String onlab) {
        return courseRepository.findByTypeStudy(onlab)
                .stream()
                .map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public CourseResponse findCourseById(Integer id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        return objectMapper.convertValue(course, CourseResponse.class);
    }


    public List<CourseResponse> findAllCourseByTopicId(Integer id) {
        return courseRepository.findByTopicId(id)
                .stream().map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());

    }
}
