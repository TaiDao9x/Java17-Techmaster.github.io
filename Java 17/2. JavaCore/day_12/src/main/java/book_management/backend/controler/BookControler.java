package book_management.backend.controler;

import book_management.backend.model.Book;
import book_management.backend.request.CreateBookRequest;
import book_management.backend.request.UpdateBookRequest;
import book_management.backend.service.BookService;

import java.util.List;

public class BookControler {
    private final BookService bookService = new BookService();

    public List<Book> getBook() {
        return bookService.getBooks();
    }

    public List<Book> getBookByName(String name) {
        return bookService.getBooksByName(name);
    }

    public void deleteBook(int id) {
        bookService.deleteBook(id);
    }

    public Book updateBook(int id, UpdateBookRequest request) {
        return bookService.updateBook(id, request);
    }

    public Book createBook(CreateBookRequest createBookRequest) {
        return bookService.createBook(createBookRequest);
    }
}
