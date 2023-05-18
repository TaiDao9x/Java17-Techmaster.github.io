package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.entity.BookEntity;
import com.example.homework_book_managerment.entity.BorrowBookEntity;
import com.example.homework_book_managerment.entity.ReaderEntity;
import com.example.homework_book_managerment.model.Book;
import com.example.homework_book_managerment.model.BorrowBook;
import com.example.homework_book_managerment.model.Reader;
import com.example.homework_book_managerment.statics.ReaderType;
import com.example.homework_book_managerment.statics.Specialized;
import com.example.homework_book_managerment.statics.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BorrowBookService {
    ObjectMapper objectMapper;
    BookService bookService;
    ReaderService readerService;

    private static final List<BorrowBookEntity> borrowBooks = new ArrayList<>();
    private static int AUTO_ID = 1;

    public List<BorrowBook> getAllBorrows() {
        List<BorrowBook> rs = new ArrayList<>();
        borrowBooks.forEach(borrowBookEntity -> {
            BorrowBook borrowBook = BorrowBook.builder()
                    .id(borrowBookEntity.getId())
                    .idBook(borrowBookEntity.getBook().getId())
                    .idReader(borrowBookEntity.getReader().getId())
                    .quantity(borrowBookEntity.getQuantity())
                    .status(borrowBookEntity.getStatus())
                    .date(borrowBookEntity.getDate())
                    .bookName(borrowBookEntity.getBook().getTitle())
                    .readerName(borrowBookEntity.getReader().getName())
                    .build();
            rs.add(borrowBook);
        });
        return rs;
    }

    public void createNewBorrow(BorrowBook borrowBook) {
        if (borrowBook == null) return;

        int idBook = borrowBook.getIdBook();
        Book book = bookService.getBookById(idBook);
        if (book == null) return;
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);

        int idReader = borrowBook.getIdReader();
        Reader reader = readerService.getReaderById(idReader);
        if (reader == null) return;
        ReaderEntity readerEntity = objectMapper.convertValue(reader, ReaderEntity.class);

        BorrowBookEntity borrowBookEntity = BorrowBookEntity.builder()
                .book(bookEntity)
                .reader(readerEntity)
                .quantity(borrowBook.getQuantity())
                .status(borrowBook.getStatus())
                .date(borrowBook.getDate())
                .build();

        borrowBookEntity.setId(AUTO_ID);
        AUTO_ID++;
        borrowBooks.add(borrowBookEntity);
    }

    public BorrowBook findBorrowById(int id) {
        for (BorrowBookEntity borrowBookEntity : borrowBooks) {
            if (borrowBookEntity.getId() == id) {
                return BorrowBook.builder()
                        .readerName(borrowBookEntity.getReader().getName())
                        .bookName(borrowBookEntity.getBook().getTitle())
                        .date(borrowBookEntity.getDate())
                        .id(borrowBookEntity.getId())
                        .idBook(borrowBookEntity.getBook().getId())
                        .idReader(borrowBookEntity.getReader().getId())
                        .quantity(borrowBookEntity.getQuantity())
                        .status(borrowBookEntity.getStatus())
                        .build();
            }
        }
        return null;
    }

    public void updateBorrow(BorrowBook borrowBook) {
        borrowBooks.forEach(borrowBookEntity -> {
            if (borrowBookEntity.getId() == borrowBook.getId()) {
                borrowBookEntity.setBook(bookService.getBookEntityById(borrowBook.getIdBook()));
                borrowBookEntity.setReader(readerService.getReaderEntityById(borrowBook.getIdReader()));
                borrowBookEntity.setDate(borrowBook.getDate());
                borrowBookEntity.setQuantity(borrowBook.getQuantity());
                borrowBookEntity.setStatus(borrowBook.getStatus());
            }
        });
    }
}
