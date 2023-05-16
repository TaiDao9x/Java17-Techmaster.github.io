package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.model.Book;
import com.example.homework_book_managerment.model.BorrowBook;
import com.example.homework_book_managerment.model.BorrowBookDetail;
import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.statics.ReaderType;
import com.example.homework_book_managerment.statics.Specialized;
import com.example.homework_book_managerment.statics.Status;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowBookService {
    private static List<BorrowBook> borrowBooks = new ArrayList<>();
    private static int AUTO_ID = 1;

    static {
        Reader reader = new Reader(10, "Tai", "HN", "0986", ReaderType.TEACHER);

        Book book = new Book(1, "abc", "dè", Specialized.CNTT, 2015);
        BorrowBookDetail borrowBookDetail = new BorrowBookDetail(book, 3, Status.NEW);

        Book book2 = new Book(2, "abc2", "dè2", Specialized.CNTT, 2015);
        BorrowBookDetail borrowBookDetail2 = new BorrowBookDetail(book2, 1, Status.NEW);

        borrowBooks.add(new BorrowBook(1, reader, borrowBookDetail, LocalDate.now()));
        borrowBooks.add(new BorrowBook(2, reader, borrowBookDetail2, LocalDate.now()));

    }

    public List<BorrowBook> getAllBorrows() {
        return borrowBooks;
    }


}
