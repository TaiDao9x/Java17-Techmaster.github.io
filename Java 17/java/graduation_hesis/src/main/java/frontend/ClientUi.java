package frontend;

import backend.controler.BookControler;
import backend.controler.UserControler;
import backend.model.Address;
import backend.model.Book;
import backend.model.User;
import backend.request.UserRequest;
import backend.ultils.FileUltils;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientUi {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();


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
                0. Đăng xuất                                
                """);
    }

    // Menu khi login vào tài khoản client (màn hình sau khi đăng nhập thành công)
    public void clientLoginSuccess(User clientLogin) {
        System.out.println("\n----------- ĐĂNG NHẬP THÀNH CÔNG -----------");
        System.out.printf("Xin chào bạn, %s. \n", clientLogin.getUserName());

        boolean isQuitLogin = false;
        while (!isQuitLogin) {
            subClientMenu();
            int option = getOption();

            switch (option) {
                case 1 -> {
                    showBook();
//                    manageOrder(clientLogin.getEmail());
                }
                case 2 -> {
                    findBook();
//                    manageOrder(clientLogin.getEmail());
                }
                case 3 -> {
//                    myCart(clientLogin.getEmail());
                }
                case 4 -> {

                }
                case 5 -> updateInfo(clientLogin.getEmail());
                case 0 -> {
                    System.out.println("\n----------- HẸN GẶP LẠI -----------");
                    isQuitLogin = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    //5.Sửa thông tin cá nhân
    public void updateInfoMenu() {
        System.out.println("""
                \n1. Thay đổi username 
                2. Thay đổi mật khẩu
                3. Thay đổi địa chỉ 
                4. Thay đổi số điện thoại
                0. Trở về menu
                    """);
    }

    public void updateInfo(String email) {
        FileUltils.printUser(userControler.getUserByEmail(email));
        boolean back = false;
        while (!back) {
            updateInfoMenu();
            int option = getOption();

            switch (option) {
                case 1 -> changeUsername(email);
                case 2 -> changePassword(email);
                case 3 -> changeAddress(email);
                case 4 -> changePhone(email);
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    //5.4 Thay đổi số điện thoại
    public void changePhone(String email) {
        String newPhone = getPhoneToUpdate();
        userControler.changePhone(email, newPhone);
        System.out.println("Thay đổi số điện thoại thành công!");
    }

    // 5.3 Thay đổi địa chỉ
    public void changeAddress(String email) {
        Address newAddress = getAddressToUpdate();
        userControler.changeAddress(email, newAddress);
        System.out.println("Đã cập nhật địa chỉ thành công!");
    }

    // 5.2 Thay đổi password
    public void changePassword(String email) {
        String newPassword = getPasswordToUpdate();
        UserRequest changePasswordRequest = new UserRequest(email, newPassword);
        userControler.changePassword(changePasswordRequest);
        System.out.println("Đã cập nhật mật khẩu thành công!");
    }

    //5.1 thay đổi username
    public void changeUsername(String email) {
        System.out.print("Nhập vào user mới: ");
        String newUsername = sc.nextLine();
        userControler.changeUsername(email, newUsername);
        System.out.println("Đã thay đổi username thành công!");
    }

    // Kiểm tra password
    public String getPasswordToUpdate() {
        boolean checkPassword = false;
        String password = "";
        while (!checkPassword) {
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            if (userControler.checkPasswordValid(password)) {
                checkPassword = true;
            } else {
                System.out.println("Password không hợp lệ!");
                System.out.println("Password phải có ít nhất 6 ký tự gồm chữ hoa, chữ thường, số và 1 ký tự đặc biệt!");
            }
        }
        return password;
    }

    // Kiểm tra phone
    public String getPhoneToUpdate() {
        boolean checkPhoned = false;
        String phone = "";
        while (!checkPhoned) {
            System.out.print("Nhập số điện thoại của bạn: ");
            phone = sc.nextLine();
            if (userControler.checkPhoneValid(phone)) {
                checkPhoned = true;
            } else {
                System.out.println("Số điện không hợp lệ!");
            }
        }
        return phone;
    }

    // Kiểm tra địa chỉ
    public Address getAddressToUpdate() {
        System.out.println("Nhập địa chỉ: ");
        System.out.print("Thành phố: ");
        String city = sc.nextLine();

        System.out.print("Quận: ");
        String district = sc.nextLine();

        System.out.print("Đường: ");
        String street = sc.nextLine();

        System.out.print("Địa chỉ nhận hàng: ");
        String addressDetail = sc.nextLine();

        return new Address(city, district, street, addressDetail);
    }


    // TẦNG SHOW DỮ LIỆU (lv3, lv4)
    // 1. Xem danh sách sản phẩm

    public void showBook() {
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    1. Xem theo thể loại \t\t 2. Xem theo nhà xuất bản\t\t0. Quay lại
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
                case 0 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 1.1. Xem theo thể loại
    public void listCategory() {

        System.out.println("""
                1. Văn học \t\t\t 2. Kinh tế \t\t 3. Tâm lý - Kỹ năng sống
                4. Nuôi dạy con \t 5. Thiếu nhi \t\t 6. Tâm linh
                0. Quay lại menu
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
                case 6 -> {
                    category = "Tâm linh";
                    backToMenu = true;
                }
                case 0 -> backToMenu = true;
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
                0. Quay lại
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
                    pulisherCompany = "trẻ";
                    backToMenu = true;
                }
                case 2 -> {
                    pulisherCompany = "Kim Đồng";
                    backToMenu = true;
                }
                case 3 -> {
                    pulisherCompany = "Lao Động";
                    backToMenu = true;
                }
                case 4 -> {
                    pulisherCompany = "Nhã Nam";
                    backToMenu = true;
                }
                case 0 -> backToMenu = true;
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
                    1. Tìm theo tên sách \t\t 2. Tìm theo tên tác giả \t\t 0. Quay lại
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
                case 0 -> backToMenu = true;
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
        return FileUltils.getOption();
    }

    public void printBook(ArrayList<Book> books) {
        FileUltils.printBook(books);
    }


}
