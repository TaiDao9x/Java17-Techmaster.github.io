package com.example.courseadmin.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateSupporterRequest {

    Integer id;

    String name;

    String phone;

    String avatar;

}
