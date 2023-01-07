package backend.User.database;

import backend.User.model.Book;
import backend.User.ultils.BookFileUltils;

import java.util.ArrayList;

public class BookDatabase {
    public static ArrayList<Book> books = BookFileUltils.getDataFromFile("book.json");

}
