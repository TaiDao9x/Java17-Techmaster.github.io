package book_managerment.service;

import book_managerment.database.BookDatabase;
import book_managerment.model.Book;
import book_managerment.repository.BookRepository;

public class BookService {
    BookRepository bookRepository = new BookRepository();

    public void findBookByTitle(String title) {
        int count = 0;
        for (Book book : bookRepository.findAll()) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có quyển sách nào có title là: " + title);
        }
    }

    public void findBookByCategory(String category) {
        int count = 0;
        for (Book book : bookRepository.findAll()) {
            if (book.category.toLowerCase().contains(category.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có thể loại: " + category);
        }
    }

    public void findBookByPublishingYear(int year) {
        int count = 0;
        for (Book book : BookDatabase.books) {
            if (book.year == year) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không sách xuất bản năm: " + year);
        }
    }
}
