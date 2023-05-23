package com.example.homeworkdriver.entity;


import com.example.homeworkdriver.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Driver extends Person {
    Level level;

    public Driver(int id, String name, String address, String phone, Level level) {
        super(id, name, address, phone);
        this.level = level;
    }

}
