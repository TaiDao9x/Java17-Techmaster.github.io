package frontend;

import backend.User.controler.BookControler;
import backend.User.controler.ItemController;
import backend.User.controler.UserControler;
import backend.User.model.*;
import backend.User.ultils.BookFileUltils;
import backend.User.ultils.ItemFileUltils;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientUi {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();
    ItemController itemController = new ItemController();


    // KHUNG TRONG CLIENT (lv2)
    // Login thành công (client)

    public void subClientMenu() {
        System.out.println("\nBạn có thể thực hiện:");
        System.out.println("""
                1. Xem danh sách sản phẩm 
                2. Tìm kiếm sản phẩm
                3. Quản lý giỏ hàng
                4. Lịch sử mua hàng
                5. Sửa thông tin cá nhân
                9. Đăng xuất                                
                """);
    }

    // Menu khi login vào tài khoản client (màn hình sau khi đăng nhập thành công)
    public void clientLoginSuccess(User clientLogin) {
        System.out.println("\n----------- ĐĂNG NHẬP THÀNH CÔNG -----------");
        System.out.printf("Xin chào \"%s\"! \n", clientLogin.getUserName().toUpperCase());

        boolean isQuitLogin = false;
        while (!isQuitLogin) {
            subClientMenu();
            int option = getOption();

            switch (option) {
                case 1 -> {
                    showBook();
                    manageOrder(clientLogin.getEmail());
                }
                case 2 -> {
                    findBook();
                    manageOrder(clientLogin.getEmail());
                }
                case 3 -> {
                    myCart(clientLogin.getEmail());
                }
                case 4 -> {

                }
                case 5 -> {

                }
                case 9 -> isQuitLogin = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 3. Quản lý đơn hàng
    public void askToBuy() {
        System.out.println("""
                \n1. Thêm sản phẩm vào giỏ hàng
                2. Xem giỏ hàng
                9. Quay lại
                 """);
    }

    public void manageOrder(String email) {
        boolean backToMenu = false;

        while (!backToMenu) {
            askToBuy();
            int option = getOption();
            switch (option) {
                case 1 -> addItemFromIdBook(email);
                case 2 -> myCart(email);
                case 9 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 3.1. Thêm sản phẩm vào giỏ hàng
    // Từ id book khách hàng nhập vào ->lấy ra Item để chuyển vào giỏ hàng

    public void addItemFromIdBook(String email) {
        boolean back = false;
        int id;
        Book book = new Book();

        while (!back) {

            try {
                System.out.print("Nhập id sản phẩm: ");
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            if (bookControler.checkIdExist(id)) {
                book = bookControler.findBookById(id);
                back = true;
            } else {
                System.out.println("Không tồn tại sản phẩm có id: " + id);
            }
        }
        Item item = new Item(email, book.getId(), book.getTitle(), 1, book.getPrice(), book.getPrice());
        itemController.addItemFromIdBook(item);
        System.out.printf("Đã thêm %s vào giỏ hàng!\n", book.getTitle());
    }

    //    3.2 Xem giỏ hàng
    public void menuCart() {
        System.out.println("""
                \n1. Xóa sản phẩm
                2. Thay đổi số lượng sản phẩm
                3. Mua hàng
                9. Quay lại chọn thêm sản phẩm
                """);
    }

    public void myCart(String email) {

        boolean backToMenu = false;

        while (!backToMenu) {
            printCart(itemController.getCart(email));
            System.out.println("Tổng số tiền cho đơn hàng này là: " + ItemFileUltils.formattingDisplay(itemController.getTotal(email)));
            if (itemController.getTotal(email) == 0) {
                System.out.println("Giỏ hàng trống!");
                backToMenu = true;
            } else {
                menuCart();
                int option = getOption();
                switch (option) {
                    case 1 -> {
                        deleteItemFromCart(email);
                        System.out.println("Đã xóa sản phẩm thành công!");
                    }
                    case 2 -> changeCount(email);
                    case 3 -> ;

                    case 9 -> backToMenu = true;
                    default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                }
            }
        }
    }

    public Order getPreOrder(String email) {
        ArrayList<Item> cart = itemController.getCart(email);
        Address address = userControler.getAddress(email);

        return new Order(cart, address);
    }

    public void changeCount(String email) {
        int id = getId();
        System.out.print("Nhập số lượng sản phẩm: ");
        int count = Integer.parseInt(sc.nextLine());
        itemController.changeCount(id, email, count);
    }

    public void deleteItemFromCart(String email) {
        boolean back = false;
        int id;

        while (!back) {
            id = getId();
            if (itemController.checkItemExist(id, email)) {
                itemController.deleteItemFromCart(id, email);
                back = true;
            } else {
                System.out.println("Không có sản phẩm trong giỏ hàng.");
            }
        }
    }

    public int getId() {
        boolean back = false;
        int id = 0;

        while (!back) {
            try {
                System.out.print("Nhập id sản phẩm: ");
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            back = true;
        }
        return id;
    }

    // TẦNG SHOW DỮ LIỆU (lv3, lv4)
    // 1. Xem danh sách sản phẩm

    public void showBook() {
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    1. Xem theo thể loại \t\t 2. Xem theo nhà xuất bản\t\t9. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    printBook(showBookByCategory());
                    backToMenu = true;
                }
                case 2 -> {
                    printBook(showBookByPulisherCompany());
                    backToMenu = true;
                }
                case 9 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 1.1. Xem theo thể loại
    public void listCategory() {

        System.out.println("""
                1. Văn học
                2. Kinh tế
                3. Tâm lý - Kỹ năng sống
                4. Nuôi dạy con
                5. Thiếu nhi
                9. Quay lại menu
                """);
    }

    // Trả về list sách theo thể loại khi đã lấy được dữ liệu loại sách muốn tìm
    public ArrayList<Book> showBookByCategory() {
        boolean backToMenu = false;
        String category = "";

        while (!backToMenu) {
            listCategory();

            int option = getOption();

            switch (option) {
                case 1 -> {
                    category = "Văn học";
                    backToMenu = true;
                }
                case 2 -> {
                    category = "Kinh tế";
                    backToMenu = true;
                }
                case 3 -> {
                    category = "Tâm lý - Kỹ năng sống";
                    backToMenu = true;
                }
                case 4 -> {
                    category = "Nuôi dạy con";
                    backToMenu = true;
                }
                case 5 -> {
                    category = "Thiếu nhi";
                    backToMenu = true;
                }
                case 9 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return bookControler.showBookByCategory(category);
    }

    // 1.2. Xem danh sách sản phẩm theo nhà xuất bản
    public void listPushlisherCompany() {
        System.out.println("""
                1. NXB trẻ
                2. NXB Kim Đồng
                3. NXB Lao Động
                4. NXB Nhã Nam
                9. Quay lại
                """);
    }

    public ArrayList<Book> showBookByPulisherCompany() {
        boolean backToMenu = false;
        String pulisherCompany = "";

        while (!backToMenu) {
            listPushlisherCompany();

            int option = getOption();

            switch (option) {
                case 1 -> {
                    pulisherCompany = "NXB trẻ";
                    backToMenu = true;
                }
                case 2 -> {
                    pulisherCompany = "NXB Kim Đồng";
                    backToMenu = true;
                }
                case 3 -> {
                    pulisherCompany = "NXB Lao Động";
                    backToMenu = true;
                }
                case 4 -> {
                    pulisherCompany = "NXB Nhã Nam";
                    backToMenu = true;
                }
                case 9 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return bookControler.showBookByPulisherCompany(pulisherCompany);
    }

    // 2. Tìm kiếm sản phẩm
    public void findBook() {
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    1. Tìm theo tên sách \t\t 2. Tìm theo tên tác giả \t\t 9. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    ArrayList<Book> books = findBookByName();
                    if (books.size() != 0) {
                        printBook(books);
                    } else {
                        System.out.println("Không có sách bạn muốn tìm!");
                    }
                    backToMenu = true;
                }
                case 2 -> {
                    ArrayList<Book> books = findBookByAuthor();
                    if (books.size() != 0) {
                        printBook(books);
                    } else {
                        System.out.println("Không có tác giả bạn muốn tìm!");
                    }
                    backToMenu = true;
                }
                case 9 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 2.1 Tìm theo tên
    public ArrayList<Book> findBookByName() {
        System.out.print("Nhập vào tên sách bạn muốn tìm: ");
        String title = sc.nextLine();
        return bookControler.findBookByName(title);
    }

    // 2.2 Tìm theo tác giả
    public ArrayList<Book> findBookByAuthor() {
        System.out.print("Nhập vào tên tác giả: ");
        String author = sc.nextLine();
        return bookControler.findBookByAuthor(author);
    }


    // Method phụ
    public int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }

    public void printBook(ArrayList<Book> books) {
        BookFileUltils.printBook(books);
    }

    public void printCart(ArrayList<Item> items) {
        ItemFileUltils.printCart(items);
    }
    // Đã làm xong chức năng tìm kiếm và show sản phẩm. Tiếp tục chuwcs năng mua hàng và sửa thông tin cá nhân

}
