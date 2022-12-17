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
                    productService.showAllProducts();
                    break;
                }
                case 2: {
                    System.out.print("\nNhập tên sản phẩm muốn tìm: ");
                    String name = sc.nextLine();

                    productService.findByName(name);
                    break;
                }
                case 3: {
                    System.out.print("\nNhập Id sản phẩm muốn tìm: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    productService.findById(id);
                    break;
                }
                case 4: {
                    System.out.print("\nNhập Id sản phẩm muốn xóa: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    productService.deleteById(id);
                    break;
                }
                case 5: {
                    System.out.print("\nNhập Id sản phẩm muốn cập nhật: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("\nNhập số lương sản phẩm: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    productService.updateById(id, quantity);
                    break;
                }
                case 6: {
                    System.out.print("\nTìm sản phẩm có số lượng dưới: ");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    productService.findByQuantity(quantity);
                    break;
                }
                case 7: {
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
        System.out.println("" +
                "1. Xem danh sách sản phẩm\n" +
                "2. Tìm sản phẩm theo tên\n" +
                "3. Tìm sản phẩm theo id\n" +
                "4. Xóa sản phẩm theo id\n" +
                "5. Cập nhật số lượng sản phẩm theo id\n" +
                "6. Tìm các sản phẩn có số lượng dưới\n" +
                "7. Tìm sản phẩm theo mức giá\n" +
                "0. Thoát chương trình");
    }
}
