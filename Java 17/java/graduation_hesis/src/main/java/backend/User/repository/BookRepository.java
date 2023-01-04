package backend.User.repository;

import backend.User.database.BookDatabase;
import backend.User.model.Book;

import java.util.ArrayList;

public class BookRepository {
    public ArrayList<Book> allBooks() {
        return BookDatabase.books();
    }

}
