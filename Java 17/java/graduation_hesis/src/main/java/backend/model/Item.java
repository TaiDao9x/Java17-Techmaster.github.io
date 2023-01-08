package backend.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private String email;
    private int id;
    private String title;
    private int count;
    private int price;
    private int monney;

}
