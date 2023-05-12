package com.example.thymleaf01.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;
    float gpa;
}
