package backend.Book.database;

import backend.Book.model.Book;
import backend.Book.ultils.BookFileUltis;

import java.util.ArrayList;

public class BookDatabase {
    public static ArrayList<Book> books() {
        return BookFileUltis.getDataFromFile("books.json");
    }
}
