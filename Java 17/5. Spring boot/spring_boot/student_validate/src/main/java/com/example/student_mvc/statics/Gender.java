package com.example.student_mvc.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    public String name;
}
