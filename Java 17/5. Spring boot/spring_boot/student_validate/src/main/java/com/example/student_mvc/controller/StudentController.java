package com.example.student_mvc.controller;

import com.example.student_mvc.model.StudentModel;
import com.example.student_mvc.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/students")
public class StudentController {

    //    @Autowired
    StudentService studentService;

    @GetMapping
    public String getStudent(Model model) {
        List<StudentModel> students = studentService.getAllStudent();
        model.addAttribute("danhSachSinhVien", students);
        return "student-list";
    }

    @GetMapping("/create-form")
    public String forwardToCreateStudentForm(Model model, StudentModel student) {
        model.addAttribute("sinhVienToiMuonTaoMoi", student);
        return "create-student";
    }

    @PostMapping
    public String createNewStudent(@ModelAttribute("sinhVienToiMuonTaoMoi") @Valid StudentModel student, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "create-student";
        } else {
            studentService.createNewStudent(student);
            return "redirect:/students";
        }
    }

    @GetMapping("/update/{id}")
    public String forwardUpdateStudent(@PathVariable int id, Model model) {
        StudentModel studentModel = studentService.getStudenById(id);
        model.addAttribute("sinhVienMuonCapNhat", studentModel);
        return "update-student";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("sinhVienMuonCapNhat") @Valid StudentModel studentModel, Errors errors) {
        if (null != errors && errors.getErrorCount() > 0) {
            return "update-student";
        } else {
            studentService.updateStudent(studentModel);
            return "redirect:/students";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}

