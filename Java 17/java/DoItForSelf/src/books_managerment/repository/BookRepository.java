package books_managerment.repository;

import books_managerment.database.BookDatabase;
import books_managerment.model.Book;

public class BookRepository {
    public Book[] findAll(){
        return BookDatabase.books;
    }
}
