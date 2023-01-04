package backend.User.database;

import backend.User.model.Book;
import backend.User.ultils.BookFileUltis;

import java.util.ArrayList;

public class BookDatabase {
    public static ArrayList<Book> books() {
        return BookFileUltis.getDataFromFile("books.json");
    }
}
