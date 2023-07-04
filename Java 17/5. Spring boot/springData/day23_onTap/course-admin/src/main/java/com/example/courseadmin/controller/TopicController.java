package com.example.courseadmin.controller;

import com.example.courseadmin.entity.Topic;
import com.example.courseadmin.model.request.CourseRequest;
import com.example.courseadmin.model.request.TopicRequest;
import com.example.courseadmin.model.response.CourseResponse;
import com.example.courseadmin.service.CourseService;
import com.example.courseadmin.service.SupporterService;
import com.example.courseadmin.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class TopicController {
    TopicService topicService;

    // Topic
    @GetMapping("/admin/topics")
    public String findAllCourses(@RequestParam(required = false, defaultValue = "1") Integer page,
                                 @RequestParam(required = false, defaultValue = "5") Integer pageSize,
                                 Model model) {
        Page<Topic> topics = topicService.getAllTopic(page,pageSize);
        model.addAttribute("topicList", topics);
        return "topic-list";
    }

    @PostMapping("/admin/topics")
    public ResponseEntity<?> createTopic(@RequestBody @Valid TopicRequest topicRequest) {
        Topic topic = topicService.createTopic(topicRequest);
        return ResponseEntity.ok(topic);
    }

    @PutMapping("/admin/topics/{id}")
    public ResponseEntity<?> updateTopic(@PathVariable Integer id, @RequestBody TopicRequest topicRequest) {
        Topic topic = topicService.updateTopic(id, topicRequest);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/api/v1/topics/{id}")
    public ResponseEntity<?> deleteTopic(@PathVariable Integer id) {
        topicService.deleteTopic(id);
        return ResponseEntity.ok(HttpEntity.EMPTY);
    }

}
