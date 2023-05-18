package com.example.homework_book_managerment.entity;

import com.example.homework_book_managerment.statics.Specialized;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class BookEntity {
    int id;
    String title;
    String author;
    Specialized specialized;
    String publishDate;

    public BookEntity() {
    }

}
