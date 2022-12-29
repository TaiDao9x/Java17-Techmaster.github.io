package homework_FPTshop.backend.database;

import homework_FPTshop.backend.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FPTShopDatabase {
    public static List<Product> list = new ArrayList<>(List.of(
            new Product(1, "Iphone X", "Sản phẩm cũ", 8_000_000, 50, 24, "Apple", List.of(new String[]{"Điện thoại", "Apple"})),
            new Product(2, "Iphone 14", "Sản phẩm mới", 35_000_000, 35, 14, "Apple", List.of(new String[]{"Điện thoại", "Apple"})),
            new Product(3, "Macbook air", "Sản phẩm cũ", 15_000_000, 60, 28, "Apple", List.of(new String[]{"Laptop", "Apple"})),
            new Product(4, "Samsung Galaxy S", "Sản phẩm cũ", 8_000_000, 15, 5, "Samsung", Collections.singletonList("Điện thoại")),
            new Product(5, "Dell 6630s", "Sản phẩm cũ", 10_500_000, 20, 12, "Dell", List.of(new String[]{"Laptop"})),
            new Product(6, "Airpod 3", "Sản phẩm mới", 2_500_000, 35, 21, "Apple", List.of(new String[]{"Apple", "Phụ kiện"})),
            new Product(7, "Vivo ", "Sản phẩm mới", 7_500_000, 30, 11, "Vivo", List.of(new String[]{"Điện thoại"})),
            new Product(8, "Sạc dự phòng", "Sản phẩm mới", 300_000, 65, 26, "AWD", List.of(new String[]{"Phụ kiện"}))


    ));
}
