package com.example.goodreads_finalproject.model.request;

import com.example.goodreads_finalproject.entity.Book;
import com.example.goodreads_finalproject.entity.User;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReviewRequest {

    @NotNull
    Long userId;

    @NotNull
    Long bookId;

    @Size(max = 65535, message = "content cannot over 65.535 characters")
    String content;

}
