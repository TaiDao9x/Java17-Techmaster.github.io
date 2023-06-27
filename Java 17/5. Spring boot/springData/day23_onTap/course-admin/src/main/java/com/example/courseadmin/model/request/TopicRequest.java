package com.example.courseadmin.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicRequest {

    @Size(max = 50)
    @NotBlank(message = "Topic name cannot be blank!")
    String name;
}
