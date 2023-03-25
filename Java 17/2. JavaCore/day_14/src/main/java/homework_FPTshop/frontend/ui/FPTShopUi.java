package homework_FPTshop.frontend.ui;

import homework_FPTshop.backend.controler.FPTShopControler;
import homework_FPTshop.backend.model.Product;

import java.awt.print.Book;
import java.util.List;
import java.util.Scanner;

public class FPTShopUi {
    private final FPTShopControler fptShopControler = new FPTShopControler();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = true;

        while (isQuit) {
            showMenu();
            try {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("lựa chọn không hợp lệ!");
            }


            switch (option) {
                case 1: {
                    System.out.println("\nĐiện thoại: ");
                    printByCategory("Điện thoại");

                    System.out.println("\nApple: ");
                    printByCategory("Apple");

                    System.out.println("\nLaptop: ");
                    printByCategory("Laptop");

                    System.out.println("\nPhụ kiện: ");
                    printByCategory("Phụ kiện");

                    break;
                }
                case 2: {
                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5:
                    break;
                case 0: {
                    isQuit = false;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không tồn tại!");
                    break;
                }
            }
        }
    }


    public void showMenu() {
        System.out.println("\n-------- MENU ---------");
        System.out.println("""
                1. In thông tin các sản phẩm dựa trên danh mục.
                2. In thông tin các sản phẩm dựa theo hãng và số sản phẩm của hãng đó
                3. In thông tin sản phẩm dựa trên mức giá và danh mục.
                Các mức giá:
                Dưới 2 triệu
                Từ 2 - 4 triệu
                Từ 4 - 7 triệu
                Từ 7 - 13 triệu
                Trên 13 triệu
                4. Tìm sản phẩm theo tên và số sản phẩm tìm được
                5. Liệt kê các hãng và số lượng sản phẩm của mỗi hãng
                0. Thoát   
                """);
    }

    public void printByCategory(String category) {
        for (Product p : fptShopControler.findByCategory(category)) {
            System.out.println(p);
        }
    }

    public void printByBrand(String Brand) {
        for (Product p : fptShopControler.printByBrand(Brand)) {
            System.out.println(p);
        }
    }
}
