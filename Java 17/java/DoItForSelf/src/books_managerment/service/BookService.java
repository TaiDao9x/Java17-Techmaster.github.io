package books_managerment.service;

import books_managerment.model.Book;
import books_managerment.repository.BookRepository;

public class BookService {
    public BookRepository bookRepository = new BookRepository();

    public void findBookByTitle(String title) {
        int count = 0;
        for (Book book : bookRepository.findAll()) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Không có sách nào title là: "+title);
        }
    }
}
