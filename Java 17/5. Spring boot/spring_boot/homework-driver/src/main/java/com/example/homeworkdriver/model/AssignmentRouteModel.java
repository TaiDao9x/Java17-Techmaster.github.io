package com.example.homeworkdriver.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AssignmentRouteModel {
    int id;

    int driverId;
    String driverName;

    int routeId;
    String routeName;

    @NotNull(message = "Number of turn cannot blank!")
    @Range(min = 1, max = 15, message = "Number of turn must be greater than 0 and less than 15 time")
    Integer numberOfTurn;

    @NotNull(message = "Date of assignment cannot blank!")
    @FutureOrPresent(message = "Date of assignment should be in future or today!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfAssignment;
}
