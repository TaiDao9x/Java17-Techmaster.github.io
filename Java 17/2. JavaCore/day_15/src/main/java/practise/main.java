package practise;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Iphone 14 Pro Max", 35_000_000, "Apple", 2));
        products.add(new Product(2, "OPPO Find X3 Pro", 9_000_000, "Oppo", 1));
        products.add(new Product(3, "Xiaomi 13", 15_000_000, "Xiaomi", 3));
        products.add(new Product(4, "Iphone 13 pro max", 21_000_000, "Apple", 2));
        products.add(new Product(5, "Samsung Z Fold 4", 42_000_000, "Samsung", 4));

        // 1.
        printInfo(products);

        // 2.
        System.out.println(formatMoney(getTotalProduct(products)));

        // 3.
        printInfo(findByBrand(products, "Apple"));

        // 4.
        System.out.println("-------4-------");
        printInfo(findByPrice(products, 20_000_000));

        // 5.
        System.out.println("-------------5------------");
        printInfo(findByName(products, "pro"));

        // 6.
        System.out.println("-----6----");
        Product product = new Product(6, "Vivo pro bet", 13_000_000, "Vivo", 6);
        products = addProduct(products, product);
        printInfo(products);
        System.out.println("-----7----");
        printInfo(findOthersasmung(products, "Samsung"));

        System.out.println("-----8----");
        printInfo(sortProduct(products));

        System.out.println("-----9----");


        printInfo(shufleProduct(products));
    }


    public static String formatMoney(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }

    //    In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
//    ID - Tên - Giá - Thương Hiệu - Số lượng
//    Ví dụ : 1- OPPO Find X3 Pro - 19500000 - OPPO - 3
    public static void printInfo(List<Product> products) {
        products.forEach(p -> System.out.println(p.getId() + " - " + p.getName() + " - "
                + formatMoney(p.getPrice()) + " - " + p.getBrand() + " - " + p.getCount()));
    }

    //    Tính tổng tiền tất cả sản phẩm trong giỏ hàng
    public static int getTotalProduct(List<Product> products) {
        return products.stream().map(product -> product.getCount() * product.getPrice()).mapToInt(t -> t).sum();
    }

    //    Tổng tiền mỗi sản phẩm = price * count
//
//    Tìm các sản phẩm của thuơng hiệu “Apple”
    public static List<Product> findByBrand(List<Product> products, String brand) {
        return products.stream()
                .filter(product -> product.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    //    Tìm các sản phẩm có giá > 20000000
    public static List<Product> findByPrice(List<Product> products, int price) {
        return products.stream()
                .filter(product -> product.getPrice() > price)
                .collect(Collectors.toList());
    }

    //    5. Tìm các sản phẩm có chữ “pro” trong tên (Không phân biệt hoa thường)
    public static List<Product> findByName(List<Product> products, String name) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    //    Thêm 1 sản phẩm bất kỳ vào trong mảng product
    public static List<Product> addProduct(List<Product> products, Product product) {
        products.add(product);
        return products;

    }

    //    Xóa tất cả sản phẩm của thương hiệu “Samsung” trong giỏ hàng
    public static List<Product> findOthersasmung(List<Product> products, String brand) {
        return products.stream().filter(n -> !n.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
    }

    //    Sắp xếp giỏ hàng theo price tăng dần
    public static List<Product> sortProduct(List<Product> products) {
        return products.stream().sorted(Comparator.comparingInt(Product::getPrice).reversed()).collect(Collectors.toList());
    }

    //    Sắp xếp giỏ hàng theo count giảm dần

    //    Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
    public static List<Product> shufleProduct(List<Product> products) {
        Collections.shuffle(products);
        return products.stream().limit(2).collect(Collectors.toList());
    }
}
