package book_management.backend.database;

import book_management.backend.model.Book;
import book_management.backend.ultils.FileUltils;

import java.util.List;

public class BookDB {
    public static List<Book> books =FileUltils.getDataFromFiles("book.json");
}
