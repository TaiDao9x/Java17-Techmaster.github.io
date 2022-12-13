package book_managerment.service;

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
            System.out.println("Khong co sach tren");
        }
    }

    public void findBookByear(int year) {
        int count = 0;

        for (Book book : bookRepository.findAll()) {
            if (book.year == year) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co sach xuat ban nam tren");
        }
    }
}
