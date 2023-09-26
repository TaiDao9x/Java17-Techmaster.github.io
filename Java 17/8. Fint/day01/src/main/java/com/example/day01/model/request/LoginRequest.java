package com.example.day01.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email format is incorrect")
    String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 3, message = "Password must be greater than 3 characters")
    String password;
}
