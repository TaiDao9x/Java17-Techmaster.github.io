package homework_FPTshop.backend.model;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {

    int id;
    String name;
    String describe;
    double price;
    int quantity;
    int sellQuantity;
    String brand;
   List<String> category;
}
