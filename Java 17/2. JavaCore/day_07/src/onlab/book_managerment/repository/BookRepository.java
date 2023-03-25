package onlab.book_managerment.repository;

import onlab.book_managerment.database.BookDatabase;
import onlab.book_managerment.model.Book;

public class BookRepository {
    public Book[] findAll() {
        return BookDatabase.books;
    }
}
