package com.example.goodreads_finalproject.model.response;

import com.example.goodreads_finalproject.entity.Role;
import com.example.goodreads_finalproject.entity.Ward;
import com.example.goodreads_finalproject.statics.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    String email;

    boolean activated;

    String roles;

    String avatar;

    String fullName;

    String gender;

    LocalDate dob;

    String phone;

    String address;
}
