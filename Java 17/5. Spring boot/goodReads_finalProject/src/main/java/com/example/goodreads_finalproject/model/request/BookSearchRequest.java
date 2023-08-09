package com.example.goodreads_finalproject.model.request;

import lombok.Data;

@Data
public class BookSearchRequest extends BaseSearchRequest {
    String all;
    String title;
    String author;
    String category;
}
