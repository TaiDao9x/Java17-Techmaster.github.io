package com.example.demojpa.DTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Employee2Dto {
    Integer id;

    String name;

    String email;
}

// C1: Query Entity -> Mapper -> Dto
// Mapper có thể tự viết, sử dụng thư viện: Object Mapper, Mapstruct
// C2: JPQL
// C3: Native query
// C4: Sử dụng Projection (Interface) -> Tự tìm hiểu