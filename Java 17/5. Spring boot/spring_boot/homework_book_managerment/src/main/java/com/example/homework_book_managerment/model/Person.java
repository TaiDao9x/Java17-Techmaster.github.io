package com.example.homework_book_managerment.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Person {
    protected int id;
    protected String name;
    protected String address;
    protected String phone;
}
