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
public class CourseService {
    CourseRepository courseRepository;
    SupporterRepository supporterRepository;
    TopicRepository topicRepository;
    ObjectMapper objectMapper;

    public List<CourseResponse> findAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(course -> objectMapper.convertValue(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    public Supporter findSupporterById(Integer id) {
        return supporterRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found supporter"));
    }

    public Topic findTopicById(Integer id) {
        return topicRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found topic"));
    }

    public Course findCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found supporter"));
    }

    public CourseResponse findCourseResponseById(Integer id) {
        return objectMapper.convertValue(findCourseById(id), CourseResponse.class);
    }

    public CourseResponse saveNewCourse(CourseRequest courseRequest) {
        Supporter supporter = findSupporterById(courseRequest.getSupporterId());
        Set<Topic> topics = new LinkedHashSet<>();
        courseRequest.getTopicIds().forEach(topicId -> topics.add(findTopicById(topicId)));

        Course course = objectMapper.convertValue(courseRequest, Course.class);
        course.setSupporter(supporter);
        course.setTopics(topics);

        courseRepository.save(course);
        return objectMapper.convertValue(course, CourseResponse.class);
    }

    public void deleteCourse(Integer id) {
        courseRepository.removeByid(id);
    }

    public CourseResponse updateCourse(Integer id, CourseRequest courseRequest) {
        Course course = findCourseById(id);
        Supporter supporter = findSupporterById(courseRequest.getSupporterId());
        Set<Topic> topics = new LinkedHashSet<>();
        courseRequest.getTopicIds().forEach(topicId -> topics.add(findTopicById(topicId)));

        course.setName(courseRequest.getName());
        course.setDescription(courseRequest.getDescription());
        course.setThumbnail(courseRequest.getThumbnail());
        course.setTypeStudy(courseRequest.getTypeStudy());
        course.setSupporter(supporter);
        course.setTopics(topics);

        courseRepository.save(course);
        return objectMapper.convertValue(course, CourseResponse.class);
    }


}
