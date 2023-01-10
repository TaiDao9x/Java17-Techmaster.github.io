package backend.service;

import backend.model.Book;
import backend.repository.BookRepository;

import java.util.*;
import java.util.stream.Collectors;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();
    ArrayList<Book> ALL_BOOKS = bookRepository.allBooks();

    public List<Book> showAllBook() {
        return ALL_BOOKS;
    }

    public ArrayList<Book> showBookByCategory(String category) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getCategory().toLowerCase().contains(category.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> showBookByPulisherCompany(String pulisherCompany) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getPublishCompany().toLowerCase().contains(pulisherCompany.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> findBookByName(String title) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> listBook = new ArrayList<>();
        for (Book book : ALL_BOOKS) {
            if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
                listBook.add(book);
            }
        }
        return listBook;
    }

    public Book findBookById(int id) {
        Book book = new Book();
        for (Book book1 : ALL_BOOKS) {
            if (book1.getId() == id) {
                book = book1;
            }
        }
        return book;
    }

    public boolean checkIdExist(int id) {
        for (Book book : ALL_BOOKS) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public int getIdBook() {
        int max = 0;
        for (Book book : ALL_BOOKS) {
            if (book.getId() > max) {
                max = book.getId();
            }
        }
        return max + 1;
    }

    public void addBook(Book newBook) {
        ALL_BOOKS.add(newBook);
        bookRepository.updateFile(ALL_BOOKS);
    }

    public ArrayList<Book> showBook() {
        return ALL_BOOKS;
    }

    public void upDatePrice(int id, int newPrice) {
        for (Book book : ALL_BOOKS) {
            if (book.getId() == id) {
                book.setPrice(newPrice);
            }
        }
        bookRepository.updateFile(ALL_BOOKS);
    }

    public void updateQuantity(int id, int newQuantity) {
        for (Book book : ALL_BOOKS) {
            if (book.getId() == id) {
                book.setQuantity(newQuantity);
            }
        }
        bookRepository.updateFile(ALL_BOOKS);
    }

    public void deleteBook(int id) {
        ALL_BOOKS.removeIf(a -> a.getId() == id);
        bookRepository.updateFile(ALL_BOOKS);
    }

    public ArrayList<Book> showBookLessx(int checkQuantity) {
        return (ArrayList<Book>) ALL_BOOKS.stream()
                .filter(n -> n.getQuantity() < checkQuantity)
                .sorted((Comparator.comparingInt(Book::getQuantity)))
                .collect(Collectors.toList());
    }

    public void changeAfterOrder(Map<Integer, Integer> reduceCount) {
        Set<Integer> set = reduceCount.keySet();
        for (Book book : ALL_BOOKS) {
            for (Integer key : set) {
                if (book.getId() == key) {
                    book.setQuantity(book.getQuantity() - reduceCount.get(key));
                }
            }
        }
        bookRepository.updateFile(ALL_BOOKS);
    }


}
