package backend.User.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin {
    private String userName;
    private String email;
    private String password;
    private String phone;
}
