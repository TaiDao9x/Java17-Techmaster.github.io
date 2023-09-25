package com.example.day01.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtResponse {

    String jwt;

    Long id;

    String email;

    Set<String> roles;

    String fullName;

}
