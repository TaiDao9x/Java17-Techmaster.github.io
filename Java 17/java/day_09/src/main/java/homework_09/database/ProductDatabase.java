package homework_09.database;

import homework_09.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {

    public ProductDatabase() {
        inIt();
    }

    public static ArrayList<Product> productList = new ArrayList<>(List.of(
            new Product(1, "Bánh", "Chocopie", 10, 60_000),
            new Product(2, "Kem đánh răng", "Colgat", 15, 35_000),
            new Product(3, "Nuớc mắm", "Nam ngư", 4, 38_000),
            new Product(4, "Dầu ăn", "Naptuyn", 8, 58_000),
            new Product(5, "Mỳ chính", "Vedan 1kg", 21, 55_000),
            new Product(6, "Bột canh", "Hải Châu", 25, 7_000),
            new Product(7, "Bánh gạo", "One One", 16, 32_000),
            new Product(8, "Bia", "Heniken", 3, 280_000),
            new Product(9, "Bánh", "Sneaker", 30, 150_000),
            new Product(10, "Nước ngọt", "Pepsi", 32, 12_000),
            new Product(11, "Kem đánh răng", "PS", 15, 33_000)
//            new Product(12, "Bao cao su", "Durex", 10, 165_000)
    ));

    public void inIt() {
        productList.add(new Product(12, "Bao cao su", "Durex", 10, 165_000));
    }

}
