package com.example.day01.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public class BaseRequest {
    Integer pageIndex = 1;
    Integer pageSize = 2;
}
