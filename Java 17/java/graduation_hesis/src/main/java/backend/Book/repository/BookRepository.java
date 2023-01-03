package backend.Book.repository;

import backend.Book.database.BookDatabase;
import backend.Book.model.Book;

import java.util.ArrayList;

public class BookRepository {
    public ArrayList<Book> allBooks() {
        return BookDatabase.books();
    }

}
