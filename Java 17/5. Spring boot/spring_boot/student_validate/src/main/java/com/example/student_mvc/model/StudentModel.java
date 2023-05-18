package com.example.student_mvc.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    int id;

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Student name cannot be blank")
    String name;

    @Size(max = 255, message = "Address cannot over 255 characters")
    @NotBlank(message = "Student address cannot be blank")
    String address;

    @NotBlank(message = "Student phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    String phone;

    @NotNull(message = "Please enter birth date")
    @Past(message = "Birth date should be less than current date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    //    @Min(value = 0, message = "GPA cannot be less than 0")
//    @Max(value = 10, message = "GPA cannot be greater than 10")
    @Range(min = 0, max = 10, message = "Gpa must be greater than 0 and less than 10")
    float gpa;
}
