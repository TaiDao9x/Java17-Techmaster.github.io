package com.example.student_mvc.controller;

import com.example.student_mvc.model.TeacherModel;
import com.example.student_mvc.service.TeacherService;
import com.example.student_mvc.statics.Gender;
import com.example.student_mvc.statics.Level;
import com.example.student_mvc.statics.Specialized;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller
@AllArgsConstructor
@RequestMapping("teachers")
public class TeacherController {
    TeacherService teacherService;


    @GetMapping
    public String getTeacher(Model model) {
        List<TeacherModel> teachers = teacherService.getAllTeachers();
        model.addAttribute("dachSachGiangVien", teachers);
        return "teacher-list";
    }

    @GetMapping("/create-form")
    public String fowardToCreateTeacherForm(Model model, TeacherModel teacher) {
        List<Level> levels = Arrays.asList(Level.values());
        List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
        List<Gender> genders = new ArrayList<>(Arrays.asList(Gender.values()));

        model.addAttribute("dsGender", genders);
        model.addAttribute("dsChuyennganh", specializeds);
        model.addAttribute("dsLevel", levels);

        model.addAttribute("giangVienToiMuonTaoMoi", teacher);
        return "create-teacher";
    }

    @PostMapping
    public String createNewTeacher(@ModelAttribute("giangVienToiMuonTaoMoi") @Valid TeacherModel teacher, Errors errors,Model model) {
        if (errors != null && errors.getErrorCount() > 0) {
            List<Level> levels = Arrays.asList(Level.values());
            List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
            List<Gender> genders = new ArrayList<>(Arrays.asList(Gender.values()));
            model.addAttribute("dsGender", genders);
            model.addAttribute("dsChuyennganh", specializeds);
            model.addAttribute("dsLevel", levels);
            return "create-teacher";
        }
        teacherService.createNewTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int teacherId, Model model) {
        List<Level> levels = Arrays.asList(Level.values());
        List<Specialized> specializeds = new ArrayList<>(Arrays.asList(Specialized.values()));
        List<Gender> genders = new ArrayList<>(Arrays.asList(Gender.values()));

        model.addAttribute("dsGender", genders);
        model.addAttribute("dsChuyennganh", specializeds);
        model.addAttribute("dsLevel", levels);

        TeacherModel teacher = teacherService.getTeacherById(teacherId);
        model.addAttribute("giangVienMuonSua", teacher);
        return "update-teacher";
    }

    @PostMapping("/update")
    public String updateTeacher(@ModelAttribute("giangVienMuonSua") @Valid TeacherModel updatedTeacher, Errors errors) {
        if (errors != null && errors.getErrorCount() > 0) {
            return "update-teacher";
        }
        teacherService.updateTeacher(updatedTeacher);
        return "redirect:/teachers";
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") int teacherId) {
        teacherService.deleteTeacher(teacherId);
        return "redirect:/teachers";
    }

}
