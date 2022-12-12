package onlab.book_managerment.model;

public class Book {

    public int id;
    public String title;
    public String author;
    public String category;
    public String publisher;
    public int year;

    public Book() {
    }

    public Book(int id, String title, String author, String category, String publisher, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.publisher = publisher;
        this.year = year;
    }

    @Override
    public String toString() {
        System.out.printf("%-5s %-25s %-20s %-15s %-15s %-5s\n", "Id", "Title", "Author", "Category", "Publisher", "Year");
        System.out.printf("%-5d %-25s %-20s %-15s %-15s %-5d\n", id, title, author, category, publisher, year);
        return "";
    }
}
