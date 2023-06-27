package com.example.courseadmin.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSupporterRequest {

    @Size(max = 50)
    String name;

    @NotBlank
    @Email
    String email;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    String phone;

}
