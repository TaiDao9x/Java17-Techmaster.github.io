package onlab.book_maneger.sevice;

import onlab.book_maneger.modern.Book;
import onlab.book_maneger.repository.BookReporitory;

public class BookService {

    public void findByTitle(String title) {
        int count = 0;
        for (Book book : BookReporitory.books) {
            if (book.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(book);
                count++;
            }
        }

        if (count == 0) {
            System.out.println("Không có quyển sách nào có title= " + title);
        }
    }
}
