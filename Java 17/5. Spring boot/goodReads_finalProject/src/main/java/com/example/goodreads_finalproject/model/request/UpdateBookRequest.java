package com.example.goodreads_finalproject.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdateBookRequest {

    Long bookId;

    String image;

    @NotBlank
    String title;

    @NotBlank
    Set<Long> categoryId;

    @NotBlank
    String author;

    String description;

    @NotBlank
    LocalDate published;

    String buyBook;

    double rating;

}
