package com.example.thymleaf01.controller;

import com.example.thymleaf01.dto.LevelDto;
import com.example.thymleaf01.model.Teacher;
import com.example.thymleaf01.service.TeacherService;
import com.example.thymleaf01.statics.Gender;
import com.example.thymleaf01.statics.Level;
import com.example.thymleaf01.statics.Specialized;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<LevelDto> levels = new ArrayList<>();
        levels.add(new LevelDto(0, "None"));
        levels.add(new LevelDto(Level.PROFESSOR.id, Level.PROFESSOR.name));
        levels.add(new LevelDto(Level.DOCTOR.id, Level.DOCTOR.name));
        levels.add(new LevelDto(Level.MASTER.id, Level.MASTER.name));

        List<LevelDto> specializeds = new ArrayList<>();
        specializeds.add(new LevelDto(0, "None"));
        specializeds.add(new LevelDto(Specialized.KHOA_HOC_TU_NHIEN.id, Specialized.KHOA_HOC_TU_NHIEN.name));
        specializeds.add(new LevelDto(Specialized.KHOA_HOC_XA_HOI.id, Specialized.KHOA_HOC_XA_HOI.name));

        List<LevelDto> genders = new ArrayList<>();
        genders.add(new LevelDto(Gender.MALE.id, Gender.MALE.name));
        genders.add(new LevelDto(Gender.FEMALE.id, Gender.FEMALE.name));
        genders.add(new LevelDto(Gender.OTHER.id, Gender.OTHER.name));

        model.addAttribute("giangVienToiMuonTaoMoi", teacher);
        model.addAttribute("dsGender", genders);
        model.addAttribute("dsChuyennganh", specializeds);
        model.addAttribute("dsLevel", levels);
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

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return "redirect:/teachers";
    }

}
