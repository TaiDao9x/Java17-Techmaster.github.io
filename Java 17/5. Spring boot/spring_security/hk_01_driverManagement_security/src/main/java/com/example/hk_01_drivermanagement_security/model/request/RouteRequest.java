package com.example.hk_01_drivermanagement_security.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteRequest {
    int id;
    String name;
    double distance;
    int numberOfStop;
}
