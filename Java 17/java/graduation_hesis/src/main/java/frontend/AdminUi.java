package frontend;

import backend.controler.AdminController;
import backend.controler.BookControler;
import backend.controler.UserControler;
import backend.model.Address;
import backend.model.Admin;
import backend.model.Book;
import backend.model.User;
import backend.ultils.FileUltils;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUi {
    Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();

    public void showMenu() {
        System.out.println("""
                \n1. Quản lý tài khoản
                2. Quản lý khách hàng
                3. Quản lý sản phẩm
                4. Quản lý đơn hàng
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
                case 2 -> manageClient();
                case 3 -> manageProduct();
                case 4 -> {
// todo quản lý đơn hàng sau khi khách hàng tạo đơn hàng
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

    // 3. Quản lý sản phẩm
    public void manageProduct() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    \n1. Xem toàn bộ sách \t\t 2. Thêm sách \t\t\t 3. Sửa sách  
                    4. Xóa sách \t\t\t\t 5. Kiểm tra sách \t\t 0. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> showBook();
                case 2 -> addBook();
                case 3 -> editBook();
                case 4 -> deleteBook();
                case 5 -> checkBook();
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 3.5 Hiển thị những đầu sach sắp hết trong kho
    public void checkBook() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    \n1. Kiểm tra số lượng sách \t\t 2. Sách best seller \t\t 0. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> showBookLessx();
                case 2 -> bookBestSeller();
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // kiểm tra số lượng sách trong kho
    public void showBookLessx() {
        int checkQuantity = getQuantity();
        FileUltils.printBook(bookControler.showBookLessx(checkQuantity));
    }

    // kiểm tra chất lượng sách theo số lượng bán ra
    public void bookBestSeller() {
        // todo: check số lượng bán ra của sách. Sách nào bán nhiều đưa lên đầu
    }


    // 3.4 xóa sách
    public void deleteBook() {
        int id = getId();
        ArrayList<Book> findBook = new ArrayList<>();
        findBook.add(bookControler.findBookById(id));
        FileUltils.printBook(findBook);

        boolean back = false;
        while (!back) {
            System.out.println("\nBạn muốn xóa sách này: ");

            System.out.print("1. Có \t\t 2. Không\n");
            int option = getOption();


            switch (option) {
                case 1 -> {
                    bookControler.deleteBook(id);
                    System.out.println("Bạn đã xóa sách thành công!");
                    back = true;
                }
                case 2 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 3.3 sửa sách
    public void editBook() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    \n1. Sửa giá \t\t 2. Cập nhật số lượng sách \t\t 0. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> upDatePrice();
                case 2 -> updateQuantity();
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // cập nhật giá sách
    public void upDatePrice() {
        int id = getId();
        int newPrice = getPrice();
        bookControler.upDatePrice(id, newPrice);
        System.out.println("Đã cập nhật giá sách thành công!");
    }

    public int getPrice() {
        boolean back = false;
        int newPrice = 0;

        while (!back) {
            try {
                System.out.print("Nhập vào giá mới: ");
                newPrice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            back = true;
        }
        return newPrice;
    }

    // cập nhật số lượng trong kho
    public void updateQuantity() {
        int id = getId();
        int newQuantity = getQuantity();
        bookControler.updateQuantity(id, newQuantity);
        System.out.println("Đã cập nhật số lượng sách trong kho!");
    }

    public int getQuantity() {
        boolean back = false;
        int newQuantity = 0;

        while (!back) {
            try {
                System.out.print("Nhập số lượng sách: ");
                newQuantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            back = true;
        }
        return newQuantity;
    }

    //3.2 thêm sách
    public void addBook() {
        int id = bookControler.getIdBook();
        System.out.print("Nhập vào tên sách:");
        String title = sc.nextLine();
        if (checkBookExist(title)) {
            System.out.println("Sách đã có trong cửa hàng!");

        } else {
            System.out.print("Nhập vào thể loại: ");
            String category = sc.nextLine();
            System.out.print("Nhập vào tên tác giả: ");
            String author = sc.nextLine();
            System.out.print("Năm xuất bản: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Giá bán: ");
            int price = Integer.parseInt(sc.nextLine());
            System.out.print("Nhà xuất bản: ");
            String publishCompany = sc.nextLine();
            System.out.print("Số lượng sản phẩm: ");
            int quantity = Integer.parseInt(sc.nextLine());
            System.out.print("Rating: ");
            double rating = Double.parseDouble(sc.nextLine());
            Book newBook = new Book(id, title, category, author, year, price, publishCompany, quantity, rating);
            bookControler.addBook(newBook);
            System.out.println("Đã thêm sách vào cửa hàng!");
        }
    }

    public boolean checkBookExist(String title) {
        return bookControler.findBookByName(title).size() > 0;
    }

    //3.1 Xem sách
    public void showBook() {
        FileUltils.printBook(bookControler.showBook());
    }


    //2. Quản lý khách hàng
    public void manageClient() {
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
        FileUltils.printUser(getUserByEmail(email));
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
        FileUltils.printUser(newUser);
    }

    public String getEmailToRegister() {
        boolean checkEmail = false;
        String email = "";
        while (!checkEmail) {
            System.out.print("Nhập email tài khoản: ");
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
                case 1 -> {
                    changeEmail(email);
                    back = true;
                }
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
        System.out.println("Đã thay đổi email thành công! Yêu cầu đổi mật khẩu.");
        changePassword(newEmail);
        System.out.println("Đăng nhập lại để hoàn tất!");
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
        return FileUltils.getOption();
    }

    public int getId() {
        return FileUltils.getId();
    }
}
