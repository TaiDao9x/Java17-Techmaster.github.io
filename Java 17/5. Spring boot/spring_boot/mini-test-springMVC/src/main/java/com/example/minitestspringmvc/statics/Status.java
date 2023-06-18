package com.example.minitestspringmvc.statics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
    UNCONFIRMED("Unconfirmed"), APPROVED("Approved"), REFUSED("Refused");

    String name;
}
