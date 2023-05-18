package com.example.homework_book_managerment.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
public class Person {
    protected int id;

    @Size(max = 50, message = "Name cannot over 50 characters")
    @NotBlank(message = "Name cannot be blank!")
    protected String name;

    @Size(max = 255, message = "Address cannot over 50 characters")
    @NotBlank(message = "Address cannot be blank!")
    protected String address;

    @NotBlank(message = "Reader phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    protected String phone;

}
