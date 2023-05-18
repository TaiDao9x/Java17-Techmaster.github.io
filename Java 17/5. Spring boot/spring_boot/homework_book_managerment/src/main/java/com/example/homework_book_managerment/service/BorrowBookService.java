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

    static {
        ReaderEntity reader = new ReaderEntity(10, "Tai", "HN", "0984600023", ReaderType.TEACHER);

        BookEntity book = new BookEntity(1, "abc", "dè", Specialized.CNTT, "2015");

        BookEntity book2 = new BookEntity(2, "abc2", "dè2", Specialized.KHOA_HOC_TU_NHIEN, "2018");

        borrowBooks.add(new BorrowBookEntity(1, reader, book, 3, Status.NEW, LocalDate.now()));
        borrowBooks.add(new BorrowBookEntity(2, reader, book2, 1, Status.NEW, LocalDate.now()));

    }

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
}
