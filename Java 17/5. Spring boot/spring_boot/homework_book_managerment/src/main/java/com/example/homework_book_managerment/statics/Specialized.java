package com.example.homework_book_managerment.statics;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Specialized {
    KHOA_HOC_TU_NHIEN("Khoa học tự nhiên"), VAN_HOC_NGHE_THUAT("Văn học nghệ thuật"), DIEN_TU_VIEN_THONG("Điện tử viễn thông"), CNTT("IT");

    String name;
}
