package com.example.thymleaf01.statics;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Gender {
    FEMALE(1, "Female"), MALE(2, "Male"), OTHER(3, "Other");

    public int id;
    public String name;
}
