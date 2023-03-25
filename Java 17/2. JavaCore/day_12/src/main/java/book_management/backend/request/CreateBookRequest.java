package book_management.backend.request;

import book_management.backend.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateBookRequest {
    private int id;
    private String title;
    private List<String> categories;
    private String author;
    private int pageNumber;
    private int releaseYear;

    public CreateBookRequest(String title, String author, int pageNumber, int releaseYear) {

        this.title = title;
        this.categories = new ArrayList<>();
        this.author = author;
        this.pageNumber = pageNumber;
        this.releaseYear = releaseYear;
    }


}
