package book_management.backend.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class UpdateBookRequest {
    private String title;
    private String author;


    public UpdateBookRequest(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
