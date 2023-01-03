package frontend;

import backend.Book.controler.BookControler;
import backend.Book.model.Book;
import backend.Book.ultils.BookFileUltis;
import backend.User.controler.UserControler;
import backend.User.model.User;
import backend.User.request.UserRequest;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();

    public void runMenu() {

        boolean isQuit = false;
        int option;

        while (!isQuit) {
            try {
                showMenuLogin();
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

            switch (option) {
                case 1 -> {
                    System.out.println("\n----------- ĐĂNG NHẬP -----------");
                    User clientLogin = getUserAfterCheckPass(getEmailToLogin());
                    clientLoginSuccess(clientLogin);
                }
                case 2 -> {
                    System.out.println("\n----------- ĐĂNG KÝ TAI KHOẢN -----------");
                    System.out.print("Nhập username: ");
                    String userName = sc.nextLine();

                    String email = getEmailToRegister();
                    String password = getPasswordToRegister();
                    String phone = getPhoneToRegister();

                    System.out.print("Nhập địa chỉ: ");
                    String address = sc.nextLine();
                    ArrayList<Book> order = new ArrayList<>();

                    User newUser = new User(userName, email, password, phone, address, order);

                    userControler.createNewUser(newUser);
                    System.out.println("Xin chúc mừng... Đã tạo tài khoản thành công!");
                    System.out.println(newUser);
                }
                case 3 -> {
                    System.out.println("\n----------- QUÊN MẬT KHẨU -----------");

                    String email = getEmailToLogin();
                    System.out.println("Tài khoản email tồn tại, hãy nhập mật khẩu mới cho tài khoản của bạn!");
                    String password = getPasswordToRegister();

                    UserRequest changePasswordRequest = new UserRequest(email, password);
                    userControler.changePassword(changePasswordRequest);
                    System.out.println("Thay đổi password thành công!");
                }
                case 0 -> isQuit = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    public void showMenuLogin() {
        System.out.println("\n-----------------------------------------");
        System.out.println("------- WELCOME TO DT'S BOOKSTORE -------");
        System.out.println("""
                1. Đăng nhập 
                2. Đăng ký
                3. Quên mật khẩu
                0. Thoát ứng dụng
                """);
        System.out.print("Nhập lựa chọn của bạn: ");
    }

    // KHUNG NGOÀI (lv1)
    // LOGIN
    // Kiểm tra, check email được nhập vào nếu đúng -> lấy ra email sang bước kiểm tra password
    // Sử dụng để lấy lại mật khẩu
    public String getEmailToLogin() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email của bạn: ");
            email = sc.nextLine();
            if (userControler.checkEmailValid(email)) {
                if (userControler.checkEmailExist(email)) {
                    checkEmail = true;
                } else {
                    System.out.println("Email không tồn tại!");
                }
            } else {
                System.out.println("Email không hợp lệ!");
            }
        }
        return email;
    }

    public User getUserByEmail(String email) {
        return userControler.getUserByEmail(email);
    }

    // Kiểm tra password theo email bên trên, nếu đúng -> lấy ra user
    public User getUserAfterCheckPass(String email) {
        User user = new User();

        boolean checkPassword = false;

        while (!checkPassword) {
            System.out.print("Nhập password: ");
            String password = sc.nextLine();
            if (password.equals(getUserByEmail(email).getPassword())) {
                user = getUserByEmail(email);
                checkPassword = true;
            } else {
                System.out.println("Password của bạn không chính xác!");
            }
        }
        return user;
    }

    // ĐĂNG KÝ TÀI KHOẢN MỚI
    // Kiểm tra tính hợp lệ của email cho phần đăng ký
    public String getEmailToRegister() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email của bạn: ");
            email = sc.nextLine();
            if (userControler.checkEmailValid(email)) {
                if (userControler.checkEmailExist(email)) {
                    System.out.println("Email đã tồn tại!");
                } else {
                    checkEmail = true;
                }
            } else {
                System.out.println("Email không hợp lệ!");
            }
        }
        return email;
    }

    // Sau khi kiemr tra email chuyển qua kiểm tra password cho phần đăng ký
    // Sử dụng để lấy lại mật khẩu

    public String getPasswordToRegister() {
        boolean checkPassword = false;
        String password = "";
        while (!checkPassword) {
            System.out.print("Nhập password: ");
            password = sc.nextLine();
            if (userControler.checkPasswordValid(password)) {
                checkPassword = true;
            } else {
                System.out.println("Email không hợp lệ!");
                System.out.println("Password phải có ít nhất 6 ký tự gồm chữ hoa, chữ thường, số và 1 ký tự đặc biệt!");
            }
        }
        return password;
    }

    // Tiếp đó là kiểm tra phone cho phần đăng ký
    public String getPhoneToRegister() {
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

    // KHUNG TRONG (lv2)
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
        System.out.print("Bạn chọn: ");
    }

    // Menu khi login vào tài khoản client (màn hình sau khi đăng nhập thành công)
    public void clientLoginSuccess(User clientLogin) {
        System.out.println("\n----------- ĐĂNG NHẬP THÀNH CÔNG -----------");
        System.out.printf("Chào mừng \"%s\"... \n", clientLogin.getUserName().toUpperCase());

        int option;
        boolean isQuitLogin = false;
        while (!isQuitLogin) {
            try {
                subClientMenu();
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

            switch (option) {
                case 1 -> {
                    showBook();

                }
                case 2 -> {
                    findBook();
                }
                case 3 -> {

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


    // TẦNG SHOW DỮ LIỆU (lv3, lv4)
    // 1. Xem danh sách sản phẩm

    public void showBook() {
        int option;
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    1. Theo thể loại
                    2. Theo nhà xuất bản
                    9. Quay lại
                    """);
            System.out.print("Bạn chọn: ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

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
        System.out.print("Bạn chọn: ");
    }

    // Trả về list sách theo thể loại khi đã lấy được dữ liệu loại sách muốn tìm
    public ArrayList<Book> showBookByCategory() {
        int option;
        boolean backToMenu = false;
        String category = "";

        while (!backToMenu) {
            try {
                listCategory();
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

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
        System.out.print("Bạn chọn: ");
    }

    public ArrayList<Book> showBookByPulisherCompany() {
        int option;
        boolean backToMenu = false;
        String pulisherCompany = "";

        while (!backToMenu) {
            try {
                listPushlisherCompany();
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

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
        int option;
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    1. Tìm theo tên sách
                    2. Tìm theo tên tác giả
                    9. Quay lại
                    """);
            System.out.print("Bạn chọn: ");

            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }

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

    public ArrayList<Book> findBookByAuthor() {
        System.out.print("Nhập vào tên tác giả: ");
        String author = sc.nextLine();
        return bookControler.findBookByAuthor(author);
    }

    // Method phụ
    // Method in sách ra màn hình theo định dạng mong muốn
    public void printBook(ArrayList<Book> books) {
        BookFileUltis.printBook(books);
    }

    // Đã làm xong chức năng tìm kiếm và show sản phẩm. Tiếp tục chuwcs năng mua hàng và sửa thông tin cá nhân
}
