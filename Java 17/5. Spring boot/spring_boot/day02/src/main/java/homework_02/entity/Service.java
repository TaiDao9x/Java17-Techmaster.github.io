package homework_02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Service {
    private int id;
    private String name;
    private int price;
    private String unit;

    private static int AUTO_ID = 100;

    public Service() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }
}
