package backend.User.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private String email;
    private int id;
    private String bookName;
    private int count;
    private int price;
    private int money;

}
