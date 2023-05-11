package com.example.thymleaf01.service;

import com.example.thymleaf01.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    private static final List<Teacher> teachers = new ArrayList<>();
    private static int AUTO_ID = 10;

    static {
        for (int i = 0; i < 10; i++) {
            Teacher teacher = Teacher.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .phone("09876543" + i)
                    .specialized("Ths")
                    .build();
            teachers.add(teacher);
        }
    }

    public List<Teacher> getAllTeachers() {
        return teachers;
    }

    public void createNewTeacher(Teacher teacher) {
        teacher.setId(AUTO_ID);
        AUTO_ID++;
        teachers.add(teacher);
    }


    public Teacher getTeacherById(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == teacherId) return teacher;
        }
        return null;
    }

    public void updateTeacher(int teacherId, Teacher updatedTeacher) {
        Teacher teacher = getTeacherById(teacherId);
        teacher.setName(updatedTeacher.getName());
        teacher.setPhone(updatedTeacher.getPhone());
        teacher.setDob(updatedTeacher.getDob());
        teacher.setGender(updatedTeacher.getGender());
        teacher.setSpecialized(updatedTeacher.getSpecialized());
        teacher.setLevel(updatedTeacher.getLevel());
    }

    public void deleteTeacher(int teacherId) {
        teachers.remove(getTeacherById(teacherId));
    }
}