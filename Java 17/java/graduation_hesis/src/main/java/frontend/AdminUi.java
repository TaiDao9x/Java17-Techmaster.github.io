package frontend;

import backend.User.controler.AdminController;
import backend.User.controler.BookControler;
import backend.User.controler.ItemController;
import backend.User.controler.UserControler;
import backend.User.model.Address;
import backend.User.model.Admin;
import backend.User.model.User;
import backend.User.service.PreOderService;
import backend.User.ultils.UserFileUltils;

import java.util.Scanner;

public class AdminUi {
    Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();
    ItemController itemController = new ItemController();
    PreOderService preOderService = new PreOderService();

    public void showMenu() {
        System.out.println("""
                \n1. Quản lý tài khoản
                2. Quản lý khách hàng
                3. Quản lý đơn hàng
                4. Quản lý sản phẩm
                5. Thống kê, báo cáo
                0. Đăng xuất
                """);

    }

    public void adminLoginSuccess(Admin admin) {
        System.out.println("\n----------- ĐĂNG NHẬP CHẾ ĐỘ ADMIN THÀNH CÔNG -----------");
        System.out.println("Xin chào Admin. Bạn có thể thực hiện: ");

        boolean isQuitLogin = false;
        while (!isQuitLogin) {
            showMenu();
            int option = getOption();

            switch (option) {
                case 1 -> manageAcount(admin.getEmail());
                case 2 -> manageClient(admin.getEmail());
                case 3 -> {
                }
                case 4 -> {

                }
                case 5 -> {
                }
                case 0 -> {
                    System.out.println("\n----------- HẸN GẶP LẠI -----------");
                    isQuitLogin = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    //2. Quản lý khách hàng
    public void manageClient(String email) {
        boolean back = false;
        while (!back) {
            System.out.println("\n1. Thêm tài khoản \t\t 2. Xóa tài khoản \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> addAcount();
                case 2 -> deleteAcount();
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 2.2 Xóa tài khoản
    public void deleteAcount() {
        String email = getEmailToDelete();
        UserFileUltils.printUser(getUserByEmail(email));
        System.out.println("Bạn có muốn xóa tài khoản này?");
        System.out.println("1. Có \t\t 2. Không");
        int option = getOption();
        if (option == 1) {
            userControler.deleteAcount(email);
            System.out.println("Đã xóa tài khoản thành công!");
        }
    }

    public String getEmailToDelete() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email tài khoản muốn xóa: ");
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

    // 2.1 thêm tài khoản
    public void addAcount() {
        System.out.print("Nhập username: ");
        String userName = sc.nextLine();

        String newEmail = getEmailToRegister();
        String password = getPasswordToRegister();
        String phone = getPhoneToRegister();
        Address address = getAddressToRegister();

        User newUser = new User(userName, newEmail, password, phone, address);

        userControler.createNewUser(newUser);
        System.out.println("Bạn đã tạo tài khoản thành công! Xin chúc mừng. ");
        UserFileUltils.printUser(newUser);
    }

    public String getEmailToRegister() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email của bạn: ");
            email = sc.nextLine();
            if (userControler.checkEmailValid(email)) {
                if (userControler.checkEmailExist(email)) {
                    System.out.println("Email đã tồn tại!");
                } else if (adminController.checkEmailExist(email)) {
                    System.out.println("Bạn không được sử dụng email này! ");
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
                System.out.println("Password không hợp lệ!");
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

    public Address getAddressToRegister() {
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

    // 1. Quản lý tài khoản
    public void manageAcount(String email) {
        boolean back = false;
        while (!back) {
            System.out.println("\n1. Thay đổi email \t\t 2. Đổi mật khẩu \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> changeEmail(email); // todo: THAY ĐỔI EMAIL PASS KO ĐƯỢC
                case 2 -> changePassword(email);
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    public void changePassword(String email) {
        String newPassword = getPasswordToUpdate();
        adminController.changePassword(email, newPassword);
        System.out.println("Đã thay đổi mật khẩu thành công!");
    }

    public void changeEmail(String email) {
        String newEmail = getNewEmail();
        adminController.changeEmail(email, newEmail);
        System.out.println("Đã thay đổi email thành công!");
    }

    // Lấy email mới
    public String getNewEmail() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email của bạn: ");
            email = sc.nextLine();
            if (adminController.checkEmailValid(email)) {
                if (userControler.checkEmailExist(email) || adminController.checkEmailExist(email)) {
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

    // Lấy, check password
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


}
