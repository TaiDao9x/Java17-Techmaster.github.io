package homework_book_managerment.model;

import java.util.Arrays;

public class Book {
    private int id;
    private String title;
    private String[] category = {"Action", "Drama", "Romance", "War", "Crime",
            "Adventure", "Comedy", "Horror", "Mystery", "Thriller", "Sci-Fi"};
    private String author;
    private int page_number;
    private int release_year;

    public Book() {
    }

    public Book(int id, String title, String[] category, String author, int pageNumber, int releaseYear) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.author = author;
        this.page_number = pageNumber;
        this.release_year = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPageNumber() {
        return page_number;
    }

    public void setPageNumber(int pageNumber) {
        this.page_number = pageNumber;
    }

    public int getReleaseYear() {
        return release_year;
    }

    public void setReleaseYear(int releaseYear) {
        this.release_year = releaseYear;
    }

    @Override
    public String toString() {
        System.out.printf("%-5d %-30s %-30s %-25s %-15d %-10d", this.getId(), this.getTitle(), Arrays.toString(this.getCategory()),
                this.getAuthor(), this.getPageNumber(), this.getReleaseYear());
        return "";
    }
}
