package com.example.courseadmin.controller;

import com.example.courseadmin.model.request.CourseRequest;
import com.example.courseadmin.model.response.CourseResponse;
import com.example.courseadmin.service.CourseService;
import com.example.courseadmin.service.SupporterService;
import com.example.courseadmin.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class CourseController {
    CourseService courseService;
    SupporterService supporterService;
    TopicService topicService;

    //    API Admin trả về View
    @GetMapping("/admin/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("allCourse", courseService.findAllCourses());
        return "course-list";
    }

    @GetMapping("/admin/create-form")
    public String createNewCoursePage(Model model) {
        model.addAttribute("topicList", topicService.getAllTopic());
        model.addAttribute("supporterList", supporterService.getAllSupporter());
        return "course-create";
    }

    @GetMapping("/admin/courses/{id}")
    public String updateCoursePage(@PathVariable Integer id, Model model) {
        model.addAttribute("courseUpdate", courseService.findCourseById(id));
        model.addAttribute("topicList", topicService.getAllTopic());
        model.addAttribute("supporterList", supporterService.getAllSupporter());
        return "course-edit";
    }

    // API Admin trả về JSON
    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<?> saveNewCourse(@RequestBody CourseRequest newCourse) {
        CourseResponse courseResponse = courseService.saveNewCourse(newCourse);
        return ResponseEntity.ok(courseResponse);
    }

    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @RequestBody @Valid CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.updateCourse(id, courseRequest);

        return ResponseEntity.ok(courseResponse);
    }

    @DeleteMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(null);
    }
}
