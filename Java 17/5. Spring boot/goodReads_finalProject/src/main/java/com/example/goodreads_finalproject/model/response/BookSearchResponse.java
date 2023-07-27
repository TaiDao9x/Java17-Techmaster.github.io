package com.example.goodreads_finalproject.model.response;

import com.example.goodreads_finalproject.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookSearchResponse {

    Long id;

    String image;

    String title;

    Set<Category> categories;

    String author;

    String description;

    double rating;

    LocalDate published;

    String buyBook;
}
