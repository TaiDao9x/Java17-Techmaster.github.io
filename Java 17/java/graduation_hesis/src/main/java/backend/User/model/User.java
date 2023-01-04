package backend.User.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String userName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private List<Book> order;

}
