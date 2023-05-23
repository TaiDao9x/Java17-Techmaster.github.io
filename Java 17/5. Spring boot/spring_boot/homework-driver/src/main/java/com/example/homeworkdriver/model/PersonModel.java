package com.example.homeworkdriver.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class PersonModel {
    int id;

    @Size(max = 50, message = "Name cannot over 50 characters")
    @NotBlank(message = "Name cannot blank!")
    String name;

    @Size(max = 100, message = "Address cannot over 100 characters")
    @NotBlank(message = "Address cannot blank!")
    String address;

    @NotBlank(message = "Phone cannot blank!")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    String phone;
}
