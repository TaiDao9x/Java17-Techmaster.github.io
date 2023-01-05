package backend.User.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Item {
    private int id;
    private String bookName;
    private int count;
    private int price;
    private int money;
    public void setMoney(int money) {
        this.money = count*price;
    }


}
