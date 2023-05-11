package com.example.thymleaf01.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

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
    LocalDate dob;
    String gender;
    String specialized;
    String level;
}
