package com.example.thymleaf01.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

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
    Locale dob;
    float gpa;

}
