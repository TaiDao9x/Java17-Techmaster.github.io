package com.example.day01.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CreateUserRequest {
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email format is incorrect")
    String email;

    @NotBlank(message = "Password cannot be blank")
    String password;

    @Pattern(regexp = "\\d{10}^$", message = "Phone mustbe 10 number characters")
    String phone;

    @Size(max = 100, message = "Full name cannot greater than 100 characters")
    String fullName;
}
