package com.example.thymleaf01.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String name;
    String address;
    String phone;
    LocalDate dob;
    float gpa;

}
