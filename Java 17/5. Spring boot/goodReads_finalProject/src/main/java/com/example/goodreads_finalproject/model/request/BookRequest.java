package com.example.goodreads_finalproject.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {
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
    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @Past
    LocalDate published;

    String buyBook;

    double rating;

}
