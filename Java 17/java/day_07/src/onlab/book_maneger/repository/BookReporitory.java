package onlab.book_maneger.repository;

import onlab.book_maneger.database.BookDatabase;
import onlab.book_maneger.modern.Book;

public class BookReporitory {
    public Book[] findAll() {
        return BookDatabase.books;
    }
}
