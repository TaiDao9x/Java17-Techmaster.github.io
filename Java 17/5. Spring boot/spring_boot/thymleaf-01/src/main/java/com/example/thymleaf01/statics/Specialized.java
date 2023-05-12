package com.example.thymleaf01.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Specialized {
    KHOA_HOC_TU_NHIEN("Khoa học tự nhiên"), KHOA_HOC_XA_HOI("Khoa học xã hội");

    public String name;

}
