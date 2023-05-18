package com.example.homework_book_managerment.entity;

import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BorrowBookEntity {
    int id;
    ReaderEntity reader;
    BookEntity book;
    int quantity;
    Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;
}
