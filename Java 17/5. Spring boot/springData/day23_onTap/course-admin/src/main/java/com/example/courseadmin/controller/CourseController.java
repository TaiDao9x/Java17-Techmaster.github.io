package com.example.courseadmin.controller;

import com.example.courseadmin.model.request.CourseRequest;
import com.example.courseadmin.model.response.CourseResponse;
import com.example.courseadmin.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping
public class CourseController {
    CourseService courseService;

    //    API Admin trả về View
    @GetMapping("/admin/courses")
    public String findAllCourses(Model model) {
        model.addAttribute("allCourse", courseService.findAllCourses());
        return "course-list";
    }

    @GetMapping("/admin/create-form")
    public String createNewCoursePage(Model model, CourseRequest newCourse) {
        model.addAttribute("khoaHocMuonTaoMoi", newCourse);
        return "course-create";
    }

    @GetMapping("/admin/courses/{id}")
    public String saveUpdateCourse(@PathVariable Integer id, Model model) {
        CourseResponse courseResponse = courseService.findCourseResponseById(id);
        model.addAttribute("khoaHocMuonSua", courseResponse);
        return "course-edit";
    }

    // API Admin trả về JSON
    @PostMapping("/api/v1/admin/courses")
    public ResponseEntity<?> saveNewCourse(@ModelAttribute("khoaHocMuonTaoMoi") @Valid CourseRequest newCourse) {
        CourseResponse courseResponse = courseService.saveNewCourse(newCourse);
        return null;
    }

    @PutMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @ModelAttribute("khoaHocMuonSua") @Valid CourseRequest courseRequest) {
        CourseResponse courseResponse = courseService.updateCourse(id, courseRequest);

        return null;
    }

    @DeleteMapping("/api/v1/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return null;
    }
}
