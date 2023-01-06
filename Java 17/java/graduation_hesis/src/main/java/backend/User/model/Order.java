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
    private String phone;
    private ArrayList<Item> item;
    private Address addressShip;
    private Date date;
    private String status;

    public Order(String email, String phone, ArrayList<Item> item, Address addressShip) {
        this.email = email;
        this.phone = phone;
        this.item = item;
        this.addressShip = addressShip;
    }


}
