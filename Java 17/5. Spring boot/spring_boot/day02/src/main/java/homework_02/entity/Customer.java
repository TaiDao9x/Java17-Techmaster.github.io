package homework_02.entity;

import homework_02.statics.CustomerType;
import lombok.*;

@Data
@AllArgsConstructor

public class Customer extends Person {
    private int id;
    private CustomerType customerType;

    private static int AUTO_ID = 10000;

    public Customer() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", customerType=" + customerType +
                '}';
    }
}
