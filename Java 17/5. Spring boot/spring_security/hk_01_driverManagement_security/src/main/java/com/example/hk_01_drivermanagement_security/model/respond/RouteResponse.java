package com.example.hk_01_drivermanagement_security.model.respond;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteResponse {
    int id;
    String name;
    double distance;
    int numberOfStop;

}
