package onlab.book_managerment.controler;

import onlab.book_managerment.service.BookService;

import java.util.Calendar;
import java.util.Scanner;

public class BookControler {
    BookService bookService = new BookService();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();
            System.out.print("Chọn chức năng: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.print("\nNhập vào tên sách: ");
                    String title = sc.nextLine();
                    bookService.findBookByTitle(title);
                    break;
                }
                case 2: {
                    System.out.print("\nNhập vào thể loại sách: ");
                    String category = sc.nextLine();
                    bookService.findBookByCategory(category);
                    break;
                }
                case 3: {
//                    System.out.print("\nNhập vào năm xuất bản: ");
                    bookService.findBookByPublishingYear(year);
                    break;
                }
                case 4: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không có!");
                    break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n---------------MENU------------------");
        System.out.println("1. Tìm sách theo tên");
        System.out.println("2. Tìm sách theo thể loại");
        System.out.println("3. Liệt kê các sách xuất bản năm 2022");
        System.out.println("4. Thoát");
    }
}
