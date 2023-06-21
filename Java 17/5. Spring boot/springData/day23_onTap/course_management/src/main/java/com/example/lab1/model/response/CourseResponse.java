package com.example.lab1.model.response;


import com.example.lab1.entity.Supporter;
import com.example.lab1.entity.Topic;
import com.example.lab1.statics.TypeStudy;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
