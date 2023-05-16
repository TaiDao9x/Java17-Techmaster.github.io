package com.example.homework_book_managerment.statics;


import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum Specialized {
    KHOA_HOC_TU_NHIEN("Khoa học tự nhiên"), VAN_HOC_NGHE_THUAT("Văn học nghệ thuật"), DIEN_TU_VIEN_THONG("Điện tử viễn thông"), CNTT("IT");

    String name;

    Specialized(String name) {
        this.name = name;
    }
}
