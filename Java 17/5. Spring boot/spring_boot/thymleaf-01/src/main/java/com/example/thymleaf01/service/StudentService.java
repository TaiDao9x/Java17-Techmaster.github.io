package com.example.thymleaf01.service;

import com.example.thymleaf01.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static final List<Student> students = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .address("Ha Noi " + i)
                    .build();
            students.add(student);
        }
    }

//    private void createData() {
//        for (int i = 0; i < 10; i++) {
//            Student student = Student.builder()
//                    .id(i)
//                    .name("Nguyen Van " + i)
//                    .address("Ha Noi " + i)
//                    .build();
//            students.add(student);
//        }
//    }

    public List<Student> getAllStudent() {
//        createData();
        return students;
    }

    public void createNewStudent(Student student) {
        students.add(student);
    }
}
