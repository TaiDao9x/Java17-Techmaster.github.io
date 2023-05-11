package com.example.thymleaf01.controller;

import com.example.thymleaf01.model.Student;
import com.example.thymleaf01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("students")
public class StudentController {

    //    @Autowired
    StudentService studentService;

    @GetMapping
    public String getStudent(Model model) {
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateStudentForm(Model model, Student student) {
        model.addAttribute("sinhVienToiMuonTaoMoi", student);
        return "create-student";
    }

    @PostMapping
    public String createNewStudent(@ModelAttribute("student") Student student) {
        studentService.createNewStudent(student);
        return "redirect:/students";
    }
}

