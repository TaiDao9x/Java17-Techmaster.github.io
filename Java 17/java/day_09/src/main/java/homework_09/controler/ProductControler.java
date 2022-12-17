package homework_09.controler;

import homework_09.service.ProductService;

import java.util.Scanner;

public class ProductControler {

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        ProductService productService = new ProductService();

        boolean isQuit = true;

        while (isQuit) {
            showMenu();

            System.out.print("\nNhập vào lựa chọn của bạn: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    // 1. Xem danh sách sản phẩm

                    productService.showAllProducts();
                    break;
                }
                case 2: {
                    // 2. Tìm sản phẩm theo tên

                    System.out.print("\nNhập tên sản phẩm muốn tìm: ");
                    String name = sc.nextLine();

                    productService.findByName(name);
                    break;
                }
                case 3: {
                    // 3. Tìm sản phẩm theo id

                    System.out.print("\nNhập Id sản phẩm muốn tìm: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    productService.findById(id);

                    break;
                }

                case 4: {
                    // 6. Tìm các san phẩm có số lượng dưới 5

                    System.out.print("\nTìm sản phẩm có số lượng dưới: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    productService.findByQuantity(quantity);
                    break;
                }
                case 5: {
                    // 5. Tìm san phẩm theo mức giá

                    System.out.println("\nTìm sản phẩm theo mức giá!");
                    System.out.print("Nhập mức giá thấp nhất: ");
                    int minPrice = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nhập mức giá cao nhất: ");
                    int maxPrice = sc.nextInt();
                    sc.nextLine();

                    productService.findByPrice(minPrice, maxPrice);
                    break;
                }
                case 0: {
                    isQuit = false;
                    break;
                }
                default:
                    System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n---------- MENU ----------");
        System.out.println("""
                1. Xem danh sách sản phẩm
                2. Tìm sản phẩm theo tên
                3. Tìm sản phẩm theo id
                4. Tìm các sản phẩn có số lượng dưới
                5. Tìm sản phẩm theo mức giá
                0. Thoát chương trình""");
    }


}
