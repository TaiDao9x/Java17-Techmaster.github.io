package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.Specialized;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class Book {
    int id;
    String title;
    String author;
    Specialized specialized;
    int publishDate;

    public Book() {
    }

}
