package com.example.thymleaf01.model;

import com.example.thymleaf01.statics.Gender;
import com.example.thymleaf01.statics.Level;
import com.example.thymleaf01.statics.Specialized;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    int id;
    String name;
    String phone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    Gender gender;
    Specialized specialized;
    Level level;

    public Teacher(Gender gender, Specialized specialized, Level level) {
        this.gender = gender;
        this.specialized = specialized;
        this.level = level;
    }

}
