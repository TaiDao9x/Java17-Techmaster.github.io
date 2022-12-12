package books_managerment.controler;

import books_managerment.service.BookService;

import java.util.Scanner;

public class BookControler {
    BookService bookService = new BookService();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);

        boolean isQuit = true;
        while (isQuit) {
            showMenu();

            System.out.print("Lựa chọn tính năng: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Nhập tên sách muốn tìm: ");
                    String title = sc.nextLine();
                    bookService.findBookByTitle(title);
                    break;
                case 4:
                    isQuit = false;
                    break;
                default:
                    System.out.println("Nhập giá trị không hợp lệ!");
            }

        }
    }

    public void showMenu() {
        System.out.println("---------MENU-----------");
        System.out.println("1. Tìm kiếm sách theo tên");
        System.out.println("2. Tìm kiếm sách theo thể loại");
        System.out.println("3. Liệt kê sách xuất bản năm nay");
        System.out.println("4. Thoát");
    }
}
