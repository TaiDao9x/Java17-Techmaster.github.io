package backend.User.controler;

import backend.User.model.Book;
import backend.User.service.BookService;

import java.util.ArrayList;

public class BookControler {
    BookService bookService = new BookService();
    public ArrayList<Book> showBookByCategory(String category) {
        return bookService.showBookByCategory(category);
    }

    public ArrayList<Book> showBookByPulisherCompany(String pulisherCompany) {
        return bookService.showBookByPulisherCompany(pulisherCompany);
    }

    public ArrayList<Book> findBookByName(String title) {
        return bookService.findBookByName(title);
    }

    public ArrayList<Book> findBookByAuthor(String author) {
       return bookService.findBookByAuthor(author);

    }
}
