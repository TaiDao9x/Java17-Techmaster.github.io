package com.example.day02.controller;

import com.example.day02.bean.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @GetMapping
    public String getStudent(Model model) {

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            students.add(new Student(i, "Nguyen Van " + i, "10A" + i, i));
        }
        model.addAttribute("students", students);
        return "student-lit";
    }
}
