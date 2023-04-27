package demo_lombok;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class Student {
    int id;
    String name;
    String address;
    LocalDate dob;
    float gpa;

}
