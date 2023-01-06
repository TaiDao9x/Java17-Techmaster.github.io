package frontend;

import backend.User.controler.BookControler;
import backend.User.controler.ItemController;
import backend.User.controler.UserControler;
import backend.User.model.*;
import backend.User.repository.PreOrderRepository;
import backend.User.service.PreOderService;
import backend.User.ultils.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientUi {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();
    ItemController itemController = new ItemController();
    PreOderService preOderService = new PreOderService();

    Ui ui = new Ui();


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
                    updateInfo(clientLogin.getEmail());
                }
                case 9 -> isQuitLogin = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    //5.Sửa thông tin cá nhân
    public void updateInfoMenu() {
        System.out.println("""
                \n1. Thay đổi username \t\t2. Thay đổi mật khẩu \t\t 3. Thay đổi địa chỉ \t\t 9. Trở về menu
                
                    """);
    }

    public void updateInfo(String email) {
        UserFileUltils.printUser(userControler.getUserByEmail(email));
        boolean back = false;
        while (!back) {
            updateInfoMenu();
            int option = getOption();

            switch (option) {
                case 1 -> changeUsername(email);
                case 2 -> changePassword(email);
                case 3 -> changeAddress(email);
                case 9 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 5.3 Thay đổi địa chỉ
    public void changeAddress(String email){
        Address newAddress = ui.getAddressToRegister();
        userControler.changeAddress(email,newAddress);
        System.out.println("Đã cập nhật địa chỉ thành công!");
    }

    // 5.2 Thay đổi password
    public void changePassword(String email) {
        String newPassword = ui.getPasswordToRegister();
        userControler.changePassword(email,newPassword);
        System.out.println("Đã cập nhật mật khẩu thành công!");
    }

    //5.1 thay đổi username
    public void changeUsername(String email) {
        System.out.print("Nhập vào user mới: ");
        String newUsername = sc.nextLine();
        userControler.changeUsername(email, newUsername);
        System.out.println("Đã thay đổi username thành công!");
    }


    // 3. Quản lý đơn hàng
    public void askToBuy() {
        System.out.println("""
                \n1. Thêm sản phẩm vào giỏ hàng \t\t 2. Xem giỏ hàng \t\t 9. Quay lại
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

    // Giỏ hàng của tôi
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
                    case 3 -> confirmPreOrder(email);

                    case 9 -> backToMenu = true;
                    default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                }
            }
        }
    }

    // Kiểm tra, thay đổi thông tin trước khi đặt hàng
    public void confirmPreOrder(String email) {
        createPreOrder(email);

        boolean back = false;
        int option;

        while (!back) {
            PreOrderFileUltils.printPreOrder(getPreOrder(email));

            System.out.println("""
                    \nHãy kiểm tra kỹ lại thông tin đơn hàng! 
                    1. Thay đổi sản phẩm
                    2. Thay đổi địa chỉ giao hàng
                    3. Đặt hàng
                    """);
            option = getOption();
            switch (option) {
                case 1 -> back = true;
                case 2 -> changeAddressPreOrder(email);
                case 3 -> {

                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        deletePreOrder(email);
    }

    // Sau khi người mua đặt hàng sẽ xóa preOder
    public void deletePreOrder(String email) {
        preOderService.deletePreOrder(email);
    }

    // Lấy hiển thị preOrder cho người mua kiểm tra trước khi đặt hàng
    public Order getPreOrder(String email) {
        return preOderService.getPreOrder(email);
    }

    // thay đổi địa chỉ giao hàng
    public void changeAddressPreOrder(String email) {
        System.out.println("Nhập địa chỉ nhận hàng: ");
        System.out.print("Thành phố: ");
        String city = sc.nextLine();

        System.out.print("Quận: ");
        String district = sc.nextLine();

        System.out.print("Đường: ");
        String street = sc.nextLine();

        System.out.print("Địa chỉ nhận hàng: ");
        String addressDetail = sc.nextLine();
        Address newAddress = new Address(city, district, street, addressDetail);
        preOderService.changeAddressPreOrder(email, newAddress);
    }

    // Tạo preOrder để người mua kiểm xa và xác nhận
    public void createPreOrder(String email) {

        String phone = userControler.getUserByEmail(email).getPhone();
        ArrayList<Item> cart = itemController.getCart(email);
        Address address = userControler.getUserByEmail(email).getAddress();
        Order newOrder = new Order(email, phone, cart, address);
        preOderService.createPreOrder(newOrder);
    }

    // Thực hiện thay đổi số lượng sản phẩm trong giỏ hàng
    public void changeCount(String email) {
        boolean idExist = false;
        int id;
        while (!idExist) {
            id = getId();
            if (itemController.checkItemExist(id, email)) {
                System.out.print("Nhập số lượng sản phẩm: ");
                int count = Integer.parseInt(sc.nextLine());
                itemController.changeCount(id, email, count);
                idExist = true;
            } else {
                System.out.println("Không có sản phẩm trong giỏ hàng.");
            }
        }

    }

    // Thực hiện xóa sản phẩm trong giỏ hàng
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

    // Lấy id sản phẩm
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

}
