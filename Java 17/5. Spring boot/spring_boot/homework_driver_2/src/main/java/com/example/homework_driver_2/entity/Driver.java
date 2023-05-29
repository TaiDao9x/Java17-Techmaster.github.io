package com.example.homework_driver_2.entity;

import com.example.homework_driver_2.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Driver {
    int id;
    String name;

    String address;

    String phone;

    Level level;
}
