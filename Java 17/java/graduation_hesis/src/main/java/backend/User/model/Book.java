package backend.User.model;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {
    private int id;
    private String title;
    private String category;
    private String author;
    private int releaseYear;
    private int price;
    private String publishCompany;
    private int quantity;
    private double rating;
}
