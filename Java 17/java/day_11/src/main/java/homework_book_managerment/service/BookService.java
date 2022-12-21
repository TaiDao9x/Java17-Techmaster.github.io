package homework_book_managerment.service;

import homework_book_managerment.model.Book;
import homework_book_managerment.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookService {
    List<Book> ALL_BOOKs = BookRepository.getListObjectFromJsonFile();
    List<Book> BOOKS_CLONE = new ArrayList<>(ALL_BOOKs);
    List<Book> BOOKS_TO_SORT = new ArrayList<>(ALL_BOOKs);


    //1. lấy thông tin toàn bộ sách
    public void getAllInfoBook() {
        formattingDisplay();
        for (Book book : BOOKS_CLONE) {
            System.out.println(book);
        }
    }

    //    2. Tìm sách theo tên
    public ArrayList<Book> findByName(String name) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : BOOKS_CLONE) {
            if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                books.add(book);
            }
        }

        return books;
    }

    //    3. Tìm sách theo category
    public ArrayList<Book> findByCategory(String category) {
        ArrayList<Book> books = new ArrayList<>();
        for (Book book : BOOKS_CLONE) {
            String categoryString = Arrays.toString(book.getCategory());
            if (categoryString.toLowerCase().contains(category.toLowerCase())) {
                books.add(book);
            }
        }
        return books;
    }

    // 4 sắp xếp theo PageNumber
    public void sortByPageNumber() {
        BOOKS_TO_SORT.sort((o1, o2) -> o1.getPageNumber() - o2.getPageNumber());
        formattingDisplay();
        for (Book book : BOOKS_TO_SORT) {
            System.out.println(book);
        }
    }

    // 5 sắp xếp theo Release year
    public void sortByReleaseYear() {
        BOOKS_TO_SORT.sort((o1, o2) -> o2.getReleaseYear() - o1.getReleaseYear());
        formattingDisplay();
        for (Book book : BOOKS_TO_SORT) {
            System.out.println(book);
        }
    }

    // 6. Thêm sách mới vào danh sách
    public void addNewBook(Book book) {
        BOOKS_CLONE.add(book);
        BookRepository.convertObjectToJsonFile(BOOKS_CLONE);
        System.out.println("Đã thêm sách thành công!");
    }


    // Method phụ
    public void formattingDisplay() {
        System.out.printf("%-5s %-30s %-30s %-25s %-15s %-15s\n",
                "Id", "Title", "Category", "Author", "Page Number", "ReleaseYear");

    }

    public int checkName(String name) {
        int count = 0;
        for (Book book : BOOKS_CLONE) {
            if (book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    public int checkCategory(String category) {
        int count = 0;
        for (Book book : BOOKS_CLONE) {
            String categoryString = Arrays.toString(book.getCategory());
            if (categoryString.toLowerCase().contains(category.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}
