package com.example.lab1.controller;

import com.example.lab1.service.CourseService;
import com.example.lab1.statics.TypeStudy;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping
public class CourseController {
    CourseService courseService;

    @GetMapping("/")
    public String findAllCourse(Model model) {
        model.addAttribute("courses", courseService.findAllCourse());
        return "course-list";
    }

    @GetMapping("/khoa-hoc/online")
    public String findAllCourseByType(Model model) {
        model.addAttribute("courses-online", courseService.findAllCourseByType(TypeStudy.ONLINE));
        return "course-online-list";
    }

    @GetMapping("/khoa-hoc/onlab")
    public String findAllCourseByType1(Model model) {
        model.addAttribute("courses-onlab", courseService.findAllCourseByType(TypeStudy.ONLAB));
        return "course-onlab-list";
    }

    @GetMapping("/khoa-hoc/{id}")
    public String findAllCourseByType1(Model model, @PathVariable Integer id) {
        model.addAttribute("details", courseService.findAllCourseById(id));
        return "detail";
    }
}

