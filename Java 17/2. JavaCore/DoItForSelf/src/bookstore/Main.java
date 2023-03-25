package bookstore;

import java.util.Scanner;

public class Main {

    private static Book books = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int function = 0;
        boolean flag = true;

        do {
            showMenu();
            function = sc.nextInt();
            sc.nextLine();

            switch (function) {
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    infoBook();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }

        } while (flag);
        sc.close();
    }

    public static void showMenu() {
        myprint("-------Book Manager----------");
        myprint("1. Add book");
        myprint("2. Edit book");
        myprint("3. Info book");
        myprint("4. Exit");
        myprint("Your choise[1-4]: ");
    }

    public static void myprint(String content) {
        System.out.println(content);
    }

    public static void addBook() {
        Scanner sc = new Scanner(System.in);
        String bookName = "";
        String bookId = "";
        double bookPrice = 0;

        myprint("ID: ");
        bookId = sc.nextLine();

        myprint("Name: ");
        bookName = sc.nextLine();

        myprint("Price: ");
        bookPrice = sc.nextDouble();

        books = new Book(bookId, bookName, bookPrice);
    }

    public static void editBook() {
        if (books != null) {
            books.showInfo();
        } else {
            myprint("Book is not exist!");
        }
    }

    public static void infoBook() {
        if (books != null) {
            books.showInfo();
        } else {
            myprint("Book is not exist!");
        }
    }
}
