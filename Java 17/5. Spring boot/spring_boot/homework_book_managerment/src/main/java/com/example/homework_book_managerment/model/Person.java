package com.example.homework_book_managerment.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
public class Person {
    protected int id;

    @Size(max = 50, message = "Name cannot over 50 characters")
    @NotBlank(message = "Name cannot be blank!")
    protected String name;

    @Size(max = 255, message = "Address cannot over 50 characters")
    @NotBlank(message = "Address cannot be blank!")
    protected String address;

    @NotBlank(message = "Reader phone cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone must be 10 number characters")
    protected String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
