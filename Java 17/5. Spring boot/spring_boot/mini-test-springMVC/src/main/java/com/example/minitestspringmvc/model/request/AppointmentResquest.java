package com.example.minitestspringmvc.model.request;

import com.example.minitestspringmvc.entity.User;
import com.example.minitestspringmvc.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AppointmentResquest {

    @NotNull
    User user;

    String description;

    Status status;

}
