package com.example.student_mvc.service;

import com.example.student_mvc.entity.TeacherEntity;
import com.example.student_mvc.model.TeacherModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    ObjectMapper objectMapper;

    private static final List<TeacherEntity> teachers = new ArrayList<>();
    private static int AUTO_ID = 10;

    static {
        for (int i = 0; i < 10; i++) {
            TeacherEntity teacher = TeacherEntity.builder()
                    .id(i)
                    .name("Nguyen Van " + i)
                    .phone("09876543" + i)
                    .build();
            teachers.add(teacher);
        }
    }

    public List<TeacherModel> getAllTeachers() {
        List<TeacherModel> result = new ArrayList<>();
        for (TeacherEntity teach : teachers) {
            TeacherModel teacherModel = objectMapper.convertValue(teach, TeacherModel.class);
            result.add(teacherModel);
        }
        return result;
    }

    public void createNewTeacher(TeacherModel teacherModel) {
        TeacherEntity teacherEntity = objectMapper.convertValue(teacherModel, TeacherEntity.class);
        teacherEntity.setId(AUTO_ID);
        AUTO_ID++;
        teachers.add(teacherEntity);
    }


    public TeacherModel getTeacherById(int id) {
        for (TeacherEntity teach : teachers) {
            if (teach.getId() == id) return objectMapper.convertValue(teach, TeacherModel.class);
        }
        return null;
    }

    public void updateTeacher(TeacherModel updatedTeacher) {
        teachers.forEach(teacher -> {
            if (teacher.getId() != updatedTeacher.getId()) {
                return;
            }
            teacher.setName(updatedTeacher.getName());
            teacher.setPhone(updatedTeacher.getPhone());
            teacher.setDob(updatedTeacher.getDob());
            teacher.setGender(updatedTeacher.getGender());
            teacher.setSpecialized(updatedTeacher.getSpecialized());
            teacher.setLevel(updatedTeacher.getLevel());
        });
    }

    public void deleteTeacher(int id) {
//        teachers.remove(objectMapper.convertValue(getTeacherById(id), TeacherEntity.class));
        teachers.removeIf(t -> t.getId() == id);
    }
}