package homework_book_managerment;

import homework_book_managerment.model.Book;
import homework_book_managerment.repository.BookRepository;

import java.util.Arrays;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        BookRepository abc = new BookRepository();
        List<Book> All = abc.getListObjectFromJsonFile();

        for (Book book : All) {
            String[] arr = book.getCategory();
            System.out.println(arr.length);
            System.out.println(Arrays.toString(arr));
        }

    }
}
