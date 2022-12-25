package book_management.backend.service;

import book_management.backend.model.Book;
import book_management.backend.repository.BookRepository;
import book_management.backend.request.CreateBookRequest;
import book_management.backend.request.UpdateBookRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String name) {
        List<Book> books = bookRepository.findAll();
        List<Book> rs = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                rs.add(book);
            }
        }
        return rs;
    }

    public void deleteBook(int id) {
        // không có sách thì báo lỗi
        Book book = bookRepository.findById(id);

        // có sách thì xóa
        bookRepository.delete(book);
    }

    public Book updateBook(int id, UpdateBookRequest request) {

        return bookRepository.update(id, request);

    }

    public Book createBook(CreateBookRequest createBookRequest) {
        Random random = new Random();

        Book book = new Book();
        book.setId(random.nextInt(1000));
        book.setTitle(createBookRequest.getTitle());
        book.setAuthor(createBookRequest.getAuthor());
        book.setCategories(createBookRequest.getCategories());
        book.setPageNumber(createBookRequest.getPageNumber());
        book.setReleaseYear(createBookRequest.getReleaseYear());

        bookRepository.save(book);
        return book;
    }
}
