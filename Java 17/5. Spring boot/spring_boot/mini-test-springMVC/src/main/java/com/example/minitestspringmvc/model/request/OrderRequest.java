package com.example.minitestspringmvc.model.request;

import com.example.minitestspringmvc.entity.Product;
import com.example.minitestspringmvc.entity.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequest {

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Teacher name cannot be blank!")
    String name;

    @NotBlank
    @Pattern(regexp = "\\d{10}", message = "Phone must be number characters")
    String phone;

    @NotBlank
    @Email
    String email;

}
