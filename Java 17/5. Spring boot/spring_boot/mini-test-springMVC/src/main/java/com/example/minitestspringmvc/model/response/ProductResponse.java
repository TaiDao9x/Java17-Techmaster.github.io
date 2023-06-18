package com.example.minitestspringmvc.model.response;

import com.example.minitestspringmvc.entity.Image;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Integer id;

    String name;

    Double price;

    String description;

    Image image;
}
