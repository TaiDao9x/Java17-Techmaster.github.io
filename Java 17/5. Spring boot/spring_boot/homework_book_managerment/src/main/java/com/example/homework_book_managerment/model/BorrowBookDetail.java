package com.example.homework_book_managerment.model;

import com.example.homework_book_managerment.statics.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowBookDetail {
    private Book book;
    private int quantity;
    private Status status;
}
