package com.example.minitestspringmvc.model.request;

import com.example.minitestspringmvc.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentRequest {

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Teacher name cannot be blank!")
    String name;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be number characters")
    String phone;

    @NotBlank
    @Email
    String email;

    String message;

    Status status;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Appointment must be in the future")
    LocalDate appointmentAt;

}
