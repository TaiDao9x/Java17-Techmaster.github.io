package backend.Book.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String title;
    private List<String> category;
    private String author;
    private int pageNumber;
    private int releaseYear;
    private int price;
    private String publishCompany;
    private int quantity;
    private double rating;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", author='" + author + '\'' +
                ", pageNumber=" + pageNumber +
                ", releaseYear=" + releaseYear +
                ", price=" + price +
                ", quantity=" + quantity +
                ", rating=" + rating +
                '}';
    }
}
