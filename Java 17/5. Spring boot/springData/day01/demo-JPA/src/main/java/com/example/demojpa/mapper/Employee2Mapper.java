package com.example.demojpa.mapper;

import com.example.demojpa.DTO.Employee2Dto;
import com.example.demojpa.entity.Employee2;

public class Employee2Mapper {
    public static Employee2Dto employee2Dto(Employee2 employee2) {
        return Employee2Dto.builder()
                .id(employee2.getId())
                .name(employee2.getName())
                .email(employee2.getEmail())
                .build();

    }
}
