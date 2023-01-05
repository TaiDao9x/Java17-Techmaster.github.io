package backend.User.model;

import lombok.*;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Cart {
    private ArrayList<Item> items;
}
