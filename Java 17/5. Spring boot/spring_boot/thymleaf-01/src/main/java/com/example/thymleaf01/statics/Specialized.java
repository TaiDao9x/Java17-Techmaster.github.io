package com.example.thymleaf01.statics;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Specialized {
    KHOA_HOC_TU_NHIEN(2, "Khoa học tự nhiên"), KHOA_HOC_XA_HOI(1, "Khoa học xã hội");

    public int id;
    public String name;

}
