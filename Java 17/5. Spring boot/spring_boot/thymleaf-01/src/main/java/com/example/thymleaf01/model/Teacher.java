package com.example.thymleaf01.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Locale;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    int id;
    String name;
    String address;
    String phone;
    Locale dob;
    String department;
}
