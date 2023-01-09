package backend.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Order {
    private int idOrder;
    private String email;
    private List<Item> cart;
    private String name;
    private String phone;
    private Address address;
    private String date;
    private Status status;

}
