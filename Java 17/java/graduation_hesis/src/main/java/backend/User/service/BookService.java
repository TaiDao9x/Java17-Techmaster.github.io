package backend.User.service;

import backend.User.model.Book;
import backend.User.repository.BookRepository;

import java.util.ArrayList;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();
    ArrayList<Book> ALL_BOOKS = bookRepository.allBooks();

    public ArrayList<Book> showBookByCategory(String category) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getCategory().contains(category)) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> showBookByPulisherCompany(String pulisherCompany) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getPublishCompany().equals(pulisherCompany)) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> findBookByName(String title) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public Book findBookById(int id) {
        Book book = new Book();
        for (Book book1 : ALL_BOOKS) {
            if (book1.getId() == id) {
                book = book1;
            }
        }
        return book;
    }

    public boolean checkIdExist(int id) {
        for (Book book : ALL_BOOKS) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
