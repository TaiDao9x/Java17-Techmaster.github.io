package com.example.student_mvc.service;

import com.example.student_mvc.entity.StudentEntity;
import com.example.student_mvc.model.StudentModel;
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

    private static final List<StudentEntity> students = new ArrayList<>();
    private static int AUTO_ID = 10;

    static {
        for (int i = 0; i < 10; i++) {
            StudentEntity student = StudentEntity.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .address("Ha Noi " + i)
                    .build();
            students.add(student);
        }
    }


    public List<StudentModel> getAllStudent() {
        List<StudentModel> rs = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            StudentEntity studentEntity = students.get(i);

//            StudentModel studentModel = StudentModel.builder()
//                    .id(student.getId())
//                    .name(student.getName())
//                    .address(student.getAddress())
//                    .phone(student.getPhone())
//                    .dob(student.getDob())
//                    .gpa(student.getGpa())
//                    .build();

            StudentModel studentModel = objectMapper.convertValue(studentEntity, StudentModel.class);

            rs.add(studentModel);
        }
        return rs;
    }

    public void createNewStudent(StudentModel studentModel) {
        StudentEntity studentEntity = objectMapper.convertValue(studentModel, StudentEntity.class);
        studentEntity.setId(AUTO_ID);
        AUTO_ID++;
        students.add(studentEntity);
    }


    public StudentModel getStudenById(int id) {
        for (StudentEntity st : students) {
            if (st.getId() == id) return objectMapper.convertValue(st, StudentModel.class);
        }
        return null;
    }

    public void updateStudent(StudentModel studentModel) {
        students.forEach(s -> {
            if (s.getId() != studentModel.getId()) {
                return;
            }
            s.setName(studentModel.getName());
            s.setAddress(studentModel.getAddress());
            s.setDob(studentModel.getDob());
            s.setGpa(studentModel.getGpa());
        });
    }

    public void deleteStudent(int id) {
        students.remove(objectMapper.convertValue(getStudenById(id), StudentEntity.class));
    }
}
