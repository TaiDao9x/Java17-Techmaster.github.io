package com.example.courseadmin.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseRequest {

    @NotBlank
    String name;

    @NotBlank
    String description;

    @NotBlank
    @Min(value = 50)
    String typeStudy;

    String thumbnail;

    Integer supporterId;

    List<Integer> topicIds;
}
