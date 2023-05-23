package com.example.homeworkdriver.model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RouteModel {
    int id;

    @NotBlank(message = "Name route cannot blank")
    @Size(max = 255, message = "Name route must be less than 255 characters")
    String name;

    @NotNull(message = "Distance cannot blank")
    @Range(max = 100, min = 5, message = "Distance must be greater than 5Km and less than 100km")
    Double distance;

    @NotNull(message = "Number of Stop cannot blank!")
    @Min(value = 1, message = "Number of Stop must be greater than 0")
    Integer numberOfStop;
}
