package com.example.day01.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CreateUserRequest {
    @NotBlank
    @Email
    String email;

    @NotBlank
    String password;

    String phone;

    String fullName;
}
