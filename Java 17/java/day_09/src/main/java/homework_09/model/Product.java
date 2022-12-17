package homework_09.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.NumberFormat;
import java.util.Locale;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter


public class Product {


    private int id;
    private String name;
    private String description;
    private int quantity;
    private double price;


    @Override
    public String toString() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(localeVN);

        System.out.printf("%-5d %-20s %-20s %-10d %-15s", this.getId(), this.getName(),
                this.getDescription(), this.getQuantity(), vn.format(this.getPrice()));
        return "";
    }

}
