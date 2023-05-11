package com.example.thymeleaf01.service;

import com.example.thymeleaf01.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

//    public List<Student> getStudents() {
//        return students;
//    }

    private void createData() {
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .id(i)
                    .name("Nguyễn Văn " + i)
                    .address("Hà Nội " + i)
                    .dob(LocalDate.now())
                    .gpa(i)
                    .build();
            students.add(student);
        }
    }

//    static {
//        for (int i = 0; i < 10; i++) {
//            Student student = Student.builder()
//                    .id(i)
//                    .name("Nguyễn Văn " + i)
//                    .address("Hà Nội " + i)
//                    .dob(LocalDate.now())
//                    .gpa(i)
//                    .build();
//            students.add(student);
//        }
//    }

    public List<Student> getAlStudents() {
        createData();
        return students;
    }

    public void saveStudent(Student student) {
        students.add(student);
    }
}
