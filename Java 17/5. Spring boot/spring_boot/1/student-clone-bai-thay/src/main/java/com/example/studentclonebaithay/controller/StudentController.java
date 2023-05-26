package com.example.studentclonebaithay.controller;

import com.example.studentclonebaithay.model.request.StudentCreateRequest;
import com.example.studentclonebaithay.model.request.StudentUpdateRequest;
import com.example.studentclonebaithay.model.response.StudentResponse;
import com.example.studentclonebaithay.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping
public class StudentController {
    StudentService studentService;

    @GetMapping("/students")
    public String getStudents(Model model) {
        List<StudentResponse> studentResponses = studentService.getAllStudents();
        model.addAttribute("danhSachSinhVien", studentResponses);

        model.addAttribute("sinhVienMuonTaoMoi", new StudentCreateRequest());

        return "student-list";
    }

    @PostMapping("/students")
    public String createNewStudent(@ModelAttribute("sinhVienMuonTaoMoi") StudentCreateRequest sinhVienMuonTaoMoi) {
        studentService.saveStudent(sinhVienMuonTaoMoi);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}/edit")
    public String forwardToUpdateForm(@PathVariable("id") String id, Model model) {
        StudentUpdateRequest studentCreateModel = studentService.findById(id);
        model.addAttribute("sinhVienToiMuonCapNhat", studentCreateModel);
//        model.addAttribute("regionData", regionService.getAll());  // --> set data vào đây hoặc dùng @ModelAttribute như bên dưới cũng được
        return "update-student";
    }

    @PostMapping("/students/update")
    public String updateStudent(@ModelAttribute("sinhVienToiMuonCapNhat") @Valid StudentUpdateRequest studentUpdateRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "update-student";
        }
        studentService.updateStudent(studentUpdateRequest);
        return "redirect:/students";
    }

}
