package backend.database;

import backend.model.Book;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class BookDatabase {
    public static ArrayList<Book> books =
            FileUltils.getBookDataFromFile("book.json");

}
