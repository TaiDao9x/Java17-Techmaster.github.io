package com.example.homework_book_managerment.entity;

import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowBookEntity {
    private int id;
    private ReaderEntity reader;
    private BookEntity book;
    private int quantity;
    private Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
