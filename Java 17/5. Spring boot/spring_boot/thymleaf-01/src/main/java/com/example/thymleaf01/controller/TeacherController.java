package com.example.thymleaf01.controller;

import com.example.thymleaf01.model.Teacher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("teachers")
public class TeacherController {

    @RequestMapping
    public String getStudent(Model model) {
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Teacher teacher = Teacher.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .address("Ha Noi " + i)
                    .build();
            teachers.add(teacher);
        }
        model.addAttribute("danhSachGiaoVien", teachers);
        return "teacher-list";
    }
}
