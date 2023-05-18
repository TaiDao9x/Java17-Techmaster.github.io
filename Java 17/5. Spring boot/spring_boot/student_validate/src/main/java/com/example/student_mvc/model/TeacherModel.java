package com.example.student_mvc.model;

import com.example.student_mvc.statics.Gender;
import com.example.student_mvc.statics.Level;
import com.example.student_mvc.statics.Specialized;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeacherModel {
    int id;

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Teacher name cannot be blank!")
    String name;

    @NotBlank(message = "Teacher phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be number characters")
    String phone;

    @NotNull(message = "Please enter your birthday")
    @Past(message = "Birth date should be less than current date!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate dob;

    @NotNull(message = "Please choose your gender!")
    Gender gender;
    Specialized specialized;
    Level level;

    public TeacherModel(Gender gender, Specialized specialized, Level level) {
        this.gender = gender;
        this.specialized = specialized;
        this.level = level;
    }
}
