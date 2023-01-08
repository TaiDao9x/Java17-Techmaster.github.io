package backend.repository;

import backend.database.BookDatabase;
import backend.model.Book;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class BookRepository {
    public ArrayList<Book> allBooks() {
        return BookDatabase.books;
    }

    public void updateFile(ArrayList<Book> books) {
        FileUltils.setDataToFile("book.json", books);
    }
}
