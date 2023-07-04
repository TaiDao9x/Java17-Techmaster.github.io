package com.example.day26_jwt_refreshtoken.entity;

import com.example.day26_jwt_refreshtoken.statics.Roles;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    Roles name;
}
