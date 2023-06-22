package com.example.courseadmin.service;

import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.repository.CourseRepository;
import com.example.courseadmin.repository.SupporterRepository;
import com.example.courseadmin.repository.TopicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SupporterService {
    CourseRepository courseRepository;
    SupporterRepository supporterRepository;
    TopicRepository topicRepository;
    ObjectMapper objectMapper;

    public List<Supporter> getAllSupporter() {
        return supporterRepository.findAll();
    }
}
