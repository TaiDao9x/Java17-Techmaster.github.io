package homework_09.repository;

import homework_09.database.ProductDatabase;
import homework_09.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductRepository {

    Scanner sc = new Scanner(System.in);

    public ArrayList<Product> showAllProducts() {
        return ProductDatabase.productList;
    }

    public void deleteProduct(int id) {
        ArrayList<Product> toRemove = new ArrayList<>();
        for (Product p : ProductDatabase.productList) {
            if (p.getId() == id) {
                toRemove.add(p);
            }
        }
        if (toRemove.size() > 0) {

            boolean out = true;
            while (out) {
                deleteMenu();
                int subOption = sc.nextInt();
                sc.nextLine();
                switch (subOption) {
                    case 1:
                        ProductDatabase.productList.removeAll(toRemove);
                        System.out.println("Đã xóa sản phẩm thành công!");
                        out = false;
                        break;
                    case 2:
                        out = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không tồn tại!");
                        break;
                }
            }

        } else {
            System.out.println("Không có sản phẩm nào có id: " + id);
        }
    }

    public void updateQuantityProduct(int id, int quantity) {
        int count = 0;
        for (Product p : ProductDatabase.productList) {
            if (p.getId() == id) {
                p.setQuantity(quantity);
                count++;
            }
        }

        if (count > 0) {
            System.out.println("Update số lượng sản phẩm thành công!");
        } else {
            System.out.println("Không có sản phẩm nào có id: " + id);
        }
    }

    public void deleteMenu() {
        System.out.println("\nBạn muốn xóa sản phẩm này?");
        System.out.println("1. Có\t\t2. Không và thoát");
        System.out.print("Bạn chọn: ");
    }
}
