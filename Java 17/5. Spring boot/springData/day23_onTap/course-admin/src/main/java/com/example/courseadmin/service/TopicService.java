package com.example.courseadmin.service;

import com.example.courseadmin.entity.Course;
import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.model.request.CourseRequest;
import com.example.courseadmin.model.response.CourseResponse;
import com.example.courseadmin.repository.CourseRepository;
import com.example.courseadmin.repository.SupporterRepository;
import com.example.courseadmin.repository.TopicRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TopicService {
    CourseRepository courseRepository;
    SupporterRepository supporterRepository;
    TopicRepository topicRepository;
    ObjectMapper objectMapper;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }
}
