package book_management.backend.repository;

import book_management.backend.database.BookDB;
import book_management.backend.exception.NotFoundException;
import book_management.backend.model.Book;
import book_management.backend.request.UpdateBookRequest;
import book_management.backend.ultils.FileUtils;

import java.util.List;

public class BookRepository {
    private final BookDB bookDB = new BookDB();

    public List<Book> findAll() {
        return bookDB.findAll();
    }


    public Book findById(int id) {
        for (Book book : BookDB.books) {
            if (book.getId() == id) {
                return book;
            }
        }
        throw new NotFoundException("Không tìm thấy quyển sách nào có id là: " + id);
    }

    public void delete(Book book) {
        BookDB.books.remove(book);
        FileUtils.setDataToFile("books.json", BookDB.books);
    }

    public Book update(int id, UpdateBookRequest request) {
        Book book = findById(id);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        FileUtils.setDataToFile("books.json", BookDB.books);
        return book;
    }

    public void save(Book book) {
        BookDB.books.add(book);
        FileUtils.setDataToFile("books.json", BookDB.books);
    }
}
