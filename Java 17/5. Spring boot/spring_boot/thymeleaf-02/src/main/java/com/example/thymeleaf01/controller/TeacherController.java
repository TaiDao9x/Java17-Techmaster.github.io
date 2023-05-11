package com.example.thymeleaf01.controller;

import com.example.thymeleaf01.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    StudentService studentService2 = new StudentService();

    public void abc(){
        studentService2.getAlStudents();
    }
}
