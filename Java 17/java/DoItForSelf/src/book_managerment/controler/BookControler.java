package book_managerment.controler;

import book_managerment.service.BookService;

import java.util.Scanner;

public class BookControler {
    public void runMenu() {
        BookService bookService = new BookService();
        Scanner sc = new Scanner(System.in);
        boolean isQuit = true;

        while (isQuit) {
            showMenu();

            System.out.print("Lua chon tinh nang: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Nhap ten sach: ");
                    String title = sc.nextLine();
                    bookService.findBookByTitle(title);
                }
                case 2 -> {
                    System.out.print("Nhap nam xuat ban: ");
                    int year = sc.nextInt();
                    bookService.findBookByear(year);
                }
                case 3 -> isQuit = false;
                default -> System.out.println("Lua chon khong chinh xac.");
            }

        }
    }

    public void showMenu() {
        System.out.println("\n-----------MENU-------------");
        System.out.println("1. Tim sach theo ten");
        System.out.println("2. Tim sach theo nam xuat ban");
        System.out.println("3. Thoat");
    }
}
