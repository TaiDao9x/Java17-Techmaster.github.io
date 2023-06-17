package com.example.minitestspringmvc.model.response;

import com.example.minitestspringmvc.entity.User;
import com.example.minitestspringmvc.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentResponse {

    Integer id;

    User user;

    String description;

    Status status;

    LocalDateTime createdAt;

    LocalDateTime confirmAt;

}
