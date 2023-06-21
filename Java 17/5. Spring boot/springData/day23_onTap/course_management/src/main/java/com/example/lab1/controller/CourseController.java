package com.example.lab1.controller;

import com.example.lab1.model.response.CourseResponse;
import com.example.lab1.service.CourseService;
import com.example.lab1.service.TopicService;
import com.example.lab1.statics.TypeStudy;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class CourseController {
    CourseService courseService;
    TopicService topicService;

    @GetMapping("/")
    public String findAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                                Model model) {
        model.addAttribute("courses", courseService.findAllCourse(page, pageSize));
        model.addAttribute("currentPage", page);
        model.addAttribute("topics", topicService.findAllTopic());
        return "course-list";
    }

    @GetMapping("/khoa-hoc/online")
    public String findAllCourseByType(@RequestParam(required = false, defaultValue = "1") Integer page,
                                      @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                                      Model model) {

        Page<CourseResponse> courseResponsePage = courseService.findAllCourseByType(page, pageSize, "online");
        model.addAttribute("coursesOnline", courseResponsePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("topics", topicService.findAllTopic());

        return "course-online-list";
    }

    @GetMapping("/khoa-hoc/onlab")
    public String findAllCourseByType1(Model model) {
        model.addAttribute("coursesOnlab", courseService.findAllCourseByType("Onlab"));
        model.addAttribute("topics", topicService.findAllTopic());

        return "course-onlab-list";
    }

    @GetMapping("/khoa-hoc/{id}")
    public String findAllCourseByType1(Model model, @PathVariable Integer id) {
        model.addAttribute("courseDetails", courseService.findCourseById(id));
        return "detail";
    }

    @GetMapping("/api/v1/khoa-hoc/{id}")
    public ResponseEntity<?> findAllCourseById(@PathVariable Integer id) {
        List<CourseResponse> courseResponses = courseService.findAllCourseByTopicId(id);
        return ResponseEntity.ok(courseResponses);
    }

}

