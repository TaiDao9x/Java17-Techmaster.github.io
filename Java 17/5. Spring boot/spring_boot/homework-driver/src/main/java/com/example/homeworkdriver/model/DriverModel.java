package com.example.homeworkdriver.model;


import com.example.homeworkdriver.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverModel extends PersonModel {
    Level level;
}
