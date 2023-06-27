package com.example.hk_01_drivermanagement_security.model.respond;

import com.example.hk_01_drivermanagement_security.statics.Level;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverResponse {
    int id;

    String name;

    String username;

    String address;

    String phone;

    Level level;

    Set<RoleResponse> roles;
}
