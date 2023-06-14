package com.example.demojpa;

import com.example.demojpa.DTO.Employee2Dto;
import com.example.demojpa.entity.Employee2;
import com.example.demojpa.mapper.Employee2Mapper;
import com.example.demojpa.repository.Employee2Repository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class Employee2Test {


    @Autowired
    private Faker faker;
    @Autowired
    private Employee2Repository employee2Repository;


    @Test
    void save_employee() {
        for (int i = 0; i < 10; i++) {
            Employee2 employee2 = new Employee2(null, faker.name().fullName(), faker.internet().emailAddress(), "111");
            employee2Repository.save(employee2);
        }
    }


    @Test
    void query_dto_mapper() {
        List<Employee2> employee2s = employee2Repository.findAll();
        List<Employee2Dto> employee2Dtos = employee2s.stream()
                .map(employee2 -> Employee2Mapper.employee2Dto(employee2)).collect(Collectors.toList());
        employee2Dtos.forEach(System.out::println);
    }

    @Test
    void query_dto_modelMapper() {
        ModelMapper mapper = new ModelMapper();
        List<Employee2> employee2s = employee2Repository.findAll();
        List<Employee2Dto> employee2Dtos = employee2s.stream()
                .map(employee2 -> mapper.map(employee2, Employee2Dto.class)).collect(Collectors.toList());
        employee2Dtos.forEach(System.out::println);
    }

    @Test
    void query_dto_jpql() {
        Employee2Dto employee2Dto = employee2Repository.getEmployee2ByEmail("harley.stracke@yahoo.com");
        System.out.println(employee2Dto);
    }

    @Test
    void query_dto_native() {
        Employee2Dto employee2Dto = employee2Repository.getEmployeeDtoUsingNQ("harley.stracke@yahoo.com");
        System.out.println(employee2Dto);
    }
}


