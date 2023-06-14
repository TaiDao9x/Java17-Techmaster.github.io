package com.example.demojparelationship.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {
    Integer id;
    String name;
    String email;

}
