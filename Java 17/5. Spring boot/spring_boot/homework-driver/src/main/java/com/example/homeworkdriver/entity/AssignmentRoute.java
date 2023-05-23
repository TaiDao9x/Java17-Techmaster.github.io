package com.example.homeworkdriver.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentRoute {
    int id;
    Driver driver;
    Route route;
    Integer numberOfTurn;
    LocalDate dateOfAssignment;
}
