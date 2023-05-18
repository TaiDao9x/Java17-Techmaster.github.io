package com.example.homework_book_managerment.service;

import com.example.homework_book_managerment.entity.BookEntity;
import com.example.homework_book_managerment.model.Book;
import com.example.homework_book_managerment.statics.Specialized;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookService {
    ObjectMapper objectMapper;

    private static final List<BookEntity> books = new ArrayList<>();
    private static int AUTO_ID = 10005;

    static {
        for (int i = 0; i < 5; i++) {
            BookEntity book = BookEntity.builder()
                    .id(i + 10000)
                    .title("CNTT đại cương phần " + (i + 1))
                    .author("Alex " + i)
                    .specialized(Specialized.CNTT)
                    .publishDate(Integer.toString(2010 + i + 1))
                    .build();
            books.add(book);
        }
    }

    public List<Book> getAllBooks() {
        List<Book> rs = new ArrayList<>();
        books.forEach(s -> {
            Book book = objectMapper.convertValue(s, Book.class);
            rs.add(book);
        });
        return rs;
    }

    public void createNewBook(Book book) {
        BookEntity bookEntity = objectMapper.convertValue(book, BookEntity.class);
        bookEntity.setId(AUTO_ID);
        AUTO_ID++;
        books.add(bookEntity);
    }

    public Book getBookById(int id) {
        for (BookEntity bookEntity : books) {
            if (bookEntity.getId() == id) {
                return objectMapper.convertValue(bookEntity, Book.class);
            }
        }
        return null;
    }

    public BookEntity getBookEntityById(int id) {
        for (BookEntity bookEntity : books) {
            if (bookEntity.getId() == id) {
                return bookEntity;
            }
        }
        return null;
    }

    public void updateBook(Book book) {

        books.forEach(bookUpdate -> {
            if (bookUpdate.getId() != book.getId()) return;
            bookUpdate.setTitle(book.getTitle());
            bookUpdate.setAuthor(book.getAuthor());
            bookUpdate.setSpecialized(book.getSpecialized());
            bookUpdate.setPublishDate(book.getPublishDate());
        });
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
