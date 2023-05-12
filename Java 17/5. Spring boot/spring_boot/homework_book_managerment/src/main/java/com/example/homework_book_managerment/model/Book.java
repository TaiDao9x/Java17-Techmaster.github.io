package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.Specialized;

import java.time.LocalDate;

public class Book {
    int id;
    String title;
    String author;
    Specialized specialized;
    LocalDate publishDate;

    public Book() {
    }

    public Book(int id, String title, String author, Specialized specialized, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.specialized = specialized;
        this.publishDate = LocalDate.of(year, 1, 1);
    }
}
