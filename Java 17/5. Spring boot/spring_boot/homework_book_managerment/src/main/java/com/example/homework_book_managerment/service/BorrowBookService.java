package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.entity.BookEntity;
import com.example.homework_book_managerment.entity.BorrowBookEntity;
import com.example.homework_book_managerment.entity.ReaderEntity;
import com.example.homework_book_managerment.model.BorrowBook;
import com.example.homework_book_managerment.statics.ReaderType;
import com.example.homework_book_managerment.statics.Specialized;
import com.example.homework_book_managerment.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BorrowBookService {
    ObjectMapper objectMapper;

    private static List<BorrowBookEntity> borrowBooks = new ArrayList<>();
    private static int AUTO_ID = 1;

    static {
        ReaderEntity reader = new ReaderEntity(10, "Tai", "HN", "0984600023", ReaderType.TEACHER);

        BookEntity book = new BookEntity(1, "abc", "dè", Specialized.CNTT, "2015");

        BookEntity book2 = new BookEntity(2, "abc2", "dè2", Specialized.KHOA_HOC_TU_NHIEN, "2018");

        borrowBooks.add(new BorrowBookEntity(1, reader, book, 3, Status.NEW, LocalDate.now()));
        borrowBooks.add(new BorrowBookEntity(2, reader, book2, 1, Status.NEW, LocalDate.now()));

    }

    public List<BorrowBook> getAllBorrows() {
        List<BorrowBook> rs = new ArrayList<>();
        borrowBooks.forEach(b -> {
            BorrowBook borrowBook = objectMapper.convertValue(b, BorrowBook.class);
            rs.add(borrowBook);
        });
        return rs;
    }

    public void createNewBorrow(BorrowBook borrowBook) {
        BorrowBookEntity borrowBookEntity = objectMapper.convertValue(borrowBook, BorrowBookEntity.class);
        borrowBookEntity.setId(AUTO_ID);
        AUTO_ID++;
        borrowBooks.add(borrowBookEntity);
    }
}
