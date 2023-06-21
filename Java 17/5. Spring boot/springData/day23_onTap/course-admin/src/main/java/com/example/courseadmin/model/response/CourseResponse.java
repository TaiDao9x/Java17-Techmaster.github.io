package com.example.courseadmin.model.response;


import com.example.courseadmin.entity.Supporter;
import com.example.courseadmin.entity.Topic;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CourseResponse {

    Integer id;

    String name;

    String description;

    String typeStudy;

    String thumbnail;

    Supporter supporter;

    List<Topic> topics;
}
