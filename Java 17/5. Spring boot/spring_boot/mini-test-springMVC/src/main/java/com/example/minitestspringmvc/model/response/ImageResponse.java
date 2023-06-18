package com.example.minitestspringmvc.model.response;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponse {

    private Integer id;

    private String type;

    private byte[] data;
}
