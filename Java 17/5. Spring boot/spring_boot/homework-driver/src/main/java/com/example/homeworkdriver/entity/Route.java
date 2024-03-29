package com.example.homeworkdriver.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Route {
    int id;
    String name;
    Double distance;
    Integer numberOfStop;
}
