package com.example.demojpa.repository;

import com.example.demojpa.DTO.Employee2Dto;
import com.example.demojpa.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Employee2Repository extends JpaRepository<Employee2, Integer> {

    @Query("""
            select new com.example.demojpa.DTO.Employee2Dto(e.id,e.name,e.email) 
            from Employee2 e
            where e.email=?1
            """)
    Employee2Dto getEmployee2ByEmail(String email);

    @Query(nativeQuery = true, name = "getEmployeeDtoUsingNQ")
    Employee2Dto getEmployeeDtoUsingNQ(String email);

}
