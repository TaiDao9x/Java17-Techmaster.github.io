package com.example.goodreads_finalproject.repository;

import com.example.goodreads_finalproject.model.request.BookSearchRequest;
import com.example.goodreads_finalproject.model.request.RatingRequest;
import com.example.goodreads_finalproject.model.response.AvgRatingResponse;
import com.example.goodreads_finalproject.model.response.BookResponse;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class BaseRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

}
