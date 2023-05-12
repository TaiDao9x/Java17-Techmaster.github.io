package com.example.manage_user_spring.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    int id;
    String userName;
    String password;
    String email;
    String phone;
}
