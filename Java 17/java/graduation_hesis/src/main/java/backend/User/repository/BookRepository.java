package backend.User.repository;

import backend.User.database.BookDatabase;
import backend.User.model.Book;
import backend.User.ultils.UserFileUltils;

import java.util.ArrayList;

public class BookRepository {
    public ArrayList<Book> allBooks() {
        return BookDatabase.books;
    }

    public void updateFile(ArrayList<Book> books) {
        UserFileUltils.setDataToFile("book.json", books);
    }
}
