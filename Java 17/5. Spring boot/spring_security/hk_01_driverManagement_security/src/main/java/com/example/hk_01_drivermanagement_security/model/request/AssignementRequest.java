package com.example.hk_01_drivermanagement_security.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AssignementRequest {

    int id;

    int driverId;
    String driverName;

    int routeId;
    String routeName;

    int numberOfTurn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dateOfAssignment;

}
