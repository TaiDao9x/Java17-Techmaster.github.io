package onlab.book_maneger.controller;

import onlab.book_maneger.sevice.BookService;

import java.util.Scanner;

public class BookControler {

    public BookService bookService = new BookService();

    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = sc.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Nhập tiêu đề cần tìm: ");
                    break;
                }
                case 2: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void doFunctionOne() {
        System.out.println("Thực hiện chức năng 1");
    }

    public static void doFunctionTwo() {
        System.out.println("Thực hiện chức năng 2");
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Tìm kiếm theo tên");
        System.out.println("2 - Thoát\n");
    }
}


