package com.example.goodreads_finalproject.model.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RatingRequest {

    @NotNull
    Long bookId;

    @NotNull
    @Size(max = 5)
    double rating;

    String readingStatus;

    Boolean hasContent;
}
