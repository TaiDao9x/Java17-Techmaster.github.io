package com.example.hk_01_drivermanagement_security.statics;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
public enum Level {
    A("Bậc A"), B("Bậc B"), C("Bậc C"), D("Bậc D"), E("Bậc E"), F("Bậc F");

    String name;
}

