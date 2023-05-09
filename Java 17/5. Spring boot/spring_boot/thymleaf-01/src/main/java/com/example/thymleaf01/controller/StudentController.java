package com.example.thymleaf01.controller;

import com.example.thymleaf01.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("students")
public class StudentController {

    @RequestMapping
    public String getStudent(Model model) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .address("Ha Noi " + i)
                    .build();
            students.add(student);
        }
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }
}
