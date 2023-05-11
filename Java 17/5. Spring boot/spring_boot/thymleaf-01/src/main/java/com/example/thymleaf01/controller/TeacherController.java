package com.example.thymleaf01.controller;

import com.example.thymleaf01.model.Teacher;
import com.example.thymleaf01.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("teachers")
public class TeacherController {
    TeacherService teacherService;

    @GetMapping
    public String getTeacher(Model model) {
        List<Teacher> teachers = teacherService.getAllTeachers();
        model.addAttribute("dachSachGiangVien", teachers);
        return "teacher-list";
    }

    @GetMapping("/create-form")
    public String fowardToCreateTeacherForm(Model model, Teacher teacher) {
        model.addAttribute("giangVienToiMuonTaoMoi", teacher);
        return "create-teacher";
    }

    @PostMapping
    public String createNewTeacher(@ModelAttribute("teacher") Teacher teacher) {
        teacherService.createNewTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int teacherId, Model model) {
        Teacher teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("teacher", teacher);
        return "update-teacher";
    }

    @PostMapping("/update/{id}")
    public String updateTeacher(@PathVariable("id") int teacherId, @ModelAttribute("teacher") Teacher updatedTeacher) {
        teacherService.updateTeacher(teacherId, updatedTeacher);
        return "redirect:/teachers";
    }

}
