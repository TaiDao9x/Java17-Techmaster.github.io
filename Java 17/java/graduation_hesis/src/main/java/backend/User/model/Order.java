package backend.User.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private String bookName;
    private int count;
    private int price;
    private int money;
    private Date date;

    public void setMoney(int money) {
        this.money = count*price;
    }
}
