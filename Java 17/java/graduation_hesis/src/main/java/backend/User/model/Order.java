package backend.User.model;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private String email;
    private ArrayList<Item> item;
    private Address addressShip;
    private Date date;
    private String status;

    public Order(ArrayList<Item> item, Address addressShip) {
        this.item = item;
        this.addressShip = addressShip;
    }
}
