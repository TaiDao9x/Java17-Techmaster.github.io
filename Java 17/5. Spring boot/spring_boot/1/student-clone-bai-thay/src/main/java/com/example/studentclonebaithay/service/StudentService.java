package com.example.studentclonebaithay.service;


import com.example.studentclonebaithay.entity.Student;
import com.example.studentclonebaithay.model.request.StudentCreateRequest;
import com.example.studentclonebaithay.model.request.StudentUpdateRequest;
import com.example.studentclonebaithay.model.response.StudentResponse;
import com.example.studentclonebaithay.statics.Region;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentService {

    ObjectMapper objectMapper;
    List<Student> students;
    private static int AUTO_ID = 1;

    public List<StudentResponse> getAllStudents() {
        List<StudentResponse> studentResponses = new ArrayList<>();
        students.forEach(student -> {
            StudentResponse studentResponse = objectMapper.convertValue(student, StudentResponse.class);
            studentResponses.add(studentResponse);
        });
        return studentResponses;
    }

    public void saveStudent(StudentCreateRequest sinhVienMuonTaoMoi) {
        Student student = objectMapper.convertValue(sinhVienMuonTaoMoi, Student.class);
        student.setId(AUTO_ID);
        students.add(student);
        AUTO_ID++;
    }

    // Thay lam optional
    public StudentUpdateRequest findById(String id) {
        for (Student student : students) {
            if (student.getId() == Integer.parseInt(id))
                return objectMapper.convertValue(student, StudentUpdateRequest.class);
        }
        return null;
    }

    public void updateStudent(StudentUpdateRequest studentUpdateRequest) {
        students.forEach(s -> {
            if (s.getId() != studentUpdateRequest.getId()) {
                return;
            }
            s.setName(studentUpdateRequest.getName());
            s.setAddress(studentUpdateRequest.getAddress());
            s.setEmail(studentUpdateRequest.getEmail());
            s.setDob(studentUpdateRequest.getDob());
            s.setGpa(studentUpdateRequest.getGpa());
            s.setRegion(Region.valueOf(studentUpdateRequest.getRegion()));
        });
    }
}
