package com.example.demojpa.entity;

import com.example.demojpa.DTO.Employee2Dto;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "resultInfo",
                classes = @ConstructorResult(
                        targetClass = Employee2Dto.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "email")
                        }
                )
        )
})
@NamedNativeQuery(
        name = "getEmployeeDtoUsingNQ",
        resultSetMapping = "resultInfo",
        query = """
                select id, name,email from employee2 where email=?1
                """)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "employee2")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String email;

    String password;

}
