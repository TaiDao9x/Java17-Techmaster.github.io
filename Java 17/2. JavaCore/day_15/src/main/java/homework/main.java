package homework;


import java.util.ArrayList;
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

        print(products);
        System.out.println(sumPrice(products));
        System.out.println(sumPrice1(products));

        print(findByBrand(products));
    }

    //    In ra thông tin các sản phẩm trong giỏ hàng theo cấu trúc sau
//    ID - Tên - Giá - Thương Hiệu - Số lượng
//    Ví dụ : 1- OPPO Find X3 Pro - 19500000 - OPPO - 3
    public static void print(List<Product> list) {
        list.forEach(n -> System.out.println(n.getId() + " - " + n.getName() + " - " + n.getPrice() + " - " + n.getBrand() + " - " + n.getCount()));
    }
//
//    Tính tổng tiền tất cả sản phẩm trong giỏ hàng
public static Integer sumPrice(List<Product> list) {
   return list.stream().map(p -> p.getPrice()*p.getCount()).mapToInt(n->n).sum();
}

//    Tổng tiền mỗi sản phẩm = price * count
public static List sumPrice1(List<Product> list) {
    return list.stream().map(p -> p.getPrice()*p.getCount()).collect(Collectors.toList());
}
//    Tìm các sản phẩm của thuơng hiệu “Apple”
public static List findByBrand(List<Product> list) {
    return list.stream().filter(n->n.getBrand().equalsIgnoreCase("Apple")).collect(Collectors.toList());
}
//    Tìm các sản phẩm có giá > 20000000
//
//    Tìm các sản phẩm có chữ “pro” trong tên (Không phân biệt hoa thường)
//
//    Thêm 1 sản phẩm bất kỳ vào trong mảng product
//
//    Xóa tất cả sản phẩm của thương hiệu “Samsung” trong giỏ hàng
//
//    Sắp xếp giỏ hàng theo price tăng dần
//
//    Sắp xếp giỏ hàng theo count giảm dần
//
//    Lấy ra 2 sản phẩm bất kỳ trong giỏ hàng
}