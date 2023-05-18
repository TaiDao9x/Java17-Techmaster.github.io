package com.example.student_mvc.entity;

import com.example.student_mvc.statics.Gender;
import com.example.student_mvc.statics.Level;
import com.example.student_mvc.statics.Specialized;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherEntity {
    int id;
    String name;
    String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    Gender gender;
    Specialized specialized;
    Level level;

    public TeacherEntity(Gender gender, Specialized specialized, Level level) {
        this.gender = gender;
        this.specialized = specialized;
        this.level = level;
    }

}
