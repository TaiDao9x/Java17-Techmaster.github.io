package book_managerment.model;

public class Book {

    public int id;
    public String title;
    public int year;

    public Book(int id, String title, int year) {
        this.id = id;
        this.title = title;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
