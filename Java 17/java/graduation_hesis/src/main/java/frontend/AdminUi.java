package frontend;

import backend.controler.AdminController;
import backend.controler.BookControler;
import backend.controler.OrderController;
import backend.controler.UserControler;
import backend.model.*;
import backend.ultils.FileUltils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminUi {
    Scanner sc = new Scanner(System.in);
    AdminController adminController = new AdminController();
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();
    OrderController orderController = new OrderController();

    public void showMenu() {
        System.out.println("""
                \n1. Tài khoản
                2. Khách hàng
                3. Sản phẩm
                4. Đơn hàng
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
                case 4 -> manageOrder();
                case 5 -> report();
                case 0 -> {
                    System.out.println("\n----------- HẸN GẶP LẠI! -----------");
                    isQuitLogin = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 5. Thống kê, báo cáo
    public void report() {
        boolean back = false;
        while (!back) {
            System.out.println("\n---------------------- THỐNG KÊ, BÁO CÁO -----------------------");
            System.out.println("1. Báo cáo doanh thu theo năm \t\t 2. Báo cáo doanh thu theo sản phẩm \t\t 0. Quay lại");
            int option = getOption();

            switch (option) {
                case 1 -> reportRevenueByYear();
                case 2 -> reportRevenueByProduct();
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 5.1: Báo cáo theo năm
    public void reportRevenueByYear() {
        int year = getYear();
        System.out.printf("\nDoanh thu năm %d là: %s \n", year, formattingNumber(getRevenueByYear(year)));

        boolean back = false;
        while (!back) {
            if (getRevenueByYear(year) > 0) {
                System.out.println("\nXem chi tiết doanh thu theo tháng. ");
                System.out.println("1. Có \t\t 2. Không \t\t 0. Quay lại");
                int option = getOption();

                switch (option) {
                    case 1 -> getRevenueByMonth(year);
                    case 2, 0 -> back = true;
                    default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                }
            } else {
                back = true;
            }
        }
    }

    // Tính doanh thu theo năm
    public int getRevenueByYear(int year) {
        return orderController.getRevenueByYear(year);
    }

    // Báo cáo doanh thu theo ngày
    public void getRevenueByMonth(int year) {
        int month = getMonth();
        if (orderController.getRevenueByMonth(month, year) > 0) {
            System.out.printf("Doanh thu tháng %d năm %d là: %s\n", month, year, formattingNumber(orderController.getRevenueByMonth(month, year)));
        } else {
            System.out.printf("Doanh thu tháng %d năm %d là: 0 VND \n", month, year);

        }
    }

    // 5.2 Báo cáo doanh thu theo sản phẩm
    public void reportRevenueByProduct() {
        FileUltils.printBookHasSold(orderController.reportRevenueByProduct());
    }

    // 4. Quản lý đơn hàng
    public void manageOrder() {
        boolean back = false;
        while (!back) {
            System.out.println("\n---------------------- QUẢN LÝ ĐƠN HÀNG -----------------------");
            System.out.println("\t\t- Tổng số đơn: " + countAllOrder());
            System.out.println("\t\t- Đơn chờ xác nhận: " + countOrder(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN));
            System.out.println("\t\t- Đơn đang chuẩn bị: " + countOrder(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG));
            System.out.println("\t\t- Đơn đang giao: " + countOrder(Status.ĐANG_GIAO_HÀNG));
            System.out.println("\t\t- Đơn đã hoàn thành: " + countOrder(Status.KHÁCH_ĐÃ_NHẬN_HÀNG));
            System.out.println("""
                    \n1. Đơn chờ xác nhận \t\t 2. Đơn đang chuẩn bị
                    3. Đơn đang vận chuyển \t\t 4. Đơn đã hoàn thành \t\t 0. Quay lại
                    """);

            int option = getOption();
            switch (option) {
                case 1 -> {
                    if (getOrdersBystatus(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN).size() > 0) {
                        showOrder(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
                        orderBrowsing(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
                    } else {
                        System.out.println("Không có đơn hàng nào!");
                    }
                }
                case 2 -> {
                    if (getOrdersBystatus(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG).size() > 0) {
                        showOrder(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG);
                        orderBrowsing(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG);
                    } else {
                        System.out.println("Không có đơn hàng nào!");
                    }
                }
                case 3 -> {
                    if (getOrdersBystatus(Status.ĐANG_GIAO_HÀNG).size() > 0) {
                        showOrder(Status.ĐANG_GIAO_HÀNG);
                        orderBrowsing(Status.ĐANG_GIAO_HÀNG);
                    } else {
                        System.out.println("Không có đơn hàng nào!");
                    }
                }
                case 4 -> {
                    if (getOrdersBystatus(Status.KHÁCH_ĐÃ_NHẬN_HÀNG).size() > 0) {
                        showOrder(Status.KHÁCH_ĐÃ_NHẬN_HÀNG);
                        orderBrowsing(Status.KHÁCH_ĐÃ_NHẬN_HÀNG);
                    } else {
                        System.out.println("Không có đơn hàng nào!");
                    }
                }
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // Đếm số đơn
    public long countAllOrder() {
        return orderController.countAllOrder();
    }

    public long countOrder(Status status) {
        return orderController.countOrder(status);
    }

    // in ra đơn hàng có trạng thái tương ứng
    public void showOrder(Status status) {
        ArrayList<Order> orders = getOrdersBystatus(status);
        printOrders(orders);
    }

    // lấy ra đơn hàng bằng status
    public ArrayList<Order> getOrdersBystatus(Status status) {
        return (ArrayList<Order>) orderController.getOrdersBystatus(status);
    }

    // Duyệt đơn hàng
    public void orderBrowsing(Status status) {
        boolean back = false;
        while (!back) {
            System.out.println("\n1. Duyệt từng đơn hàng \t\t 2. Duyệt tất cả đơn hàng \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> browingOneByOne(status);
                case 2 -> browingAll(status);
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // case 1. Duyệt từng đơn hàng
    public void browingOneByOne(Status status) {

        boolean back = false;
        while (!back) {
            System.out.println("\nHãy chọn id đơn hàng muốn sửa!");
            int idOrder = getIdOrder();
            if (checkIdOrderExist(idOrder, status)) {
                changeStatus(idOrder);
            } else {
                System.out.println("Id đơn hàng không có!");
            }
            back = true;
        }
    }

    public boolean checkIdOrderExist(int id, Status status) {
        return getOrdersBystatus(status).stream()
                .anyMatch(n -> n.getIdOrder() == id);
    }

    public void changeStatus(int id) {
        boolean back = false;
        while (!back) {
            System.out.println("Bạn muốn thay đổi đơn hàng này thành: ");
            System.out.println("""
                    1. CHỜ_NGƯỜI_BÁN_XÁC_NHẬN
                    2. NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG
                    3. ĐANG_GIAO_HÀNG
                    4. KHÁCH_ĐÃ_NHẬN_HÀNG
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    orderController.changeStatus(id, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
                    back = true;
                }
                case 2 -> {
                    orderController.changeStatus(id, Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG);
                    back = true;
                }
                case 3 -> {
                    orderController.changeStatus(id, Status.ĐANG_GIAO_HÀNG);
                    back = true;
                }
                case 4 -> {
                    orderController.changeStatus(id, Status.KHÁCH_ĐÃ_NHẬN_HÀNG);
                    back = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        System.out.println("Thay đổi thành công!");
    }

    // case 2: duyệt tất cả đơn
    public void browingAll(Status status) {
        boolean back = false;
        while (!back) {
            System.out.println("Bạn muốn thay đổi tất cả đơn hàng này thành: ");
            System.out.println("""
                    1. CHỜ_NGƯỜI_BÁN_XÁC_NHẬN
                    2. NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG
                    3. ĐANG_GIAO_HÀNG
                    4. KHÁCH_ĐÃ_NHẬN_HÀNG
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    orderController.changeAllStatus(status, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
                    back = true;
                }
                case 2 -> {
                    orderController.changeAllStatus(status, Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG);
                    back = true;
                }
                case 3 -> {
                    orderController.changeAllStatus(status, Status.ĐANG_GIAO_HÀNG);
                    back = true;
                }
                case 4 -> {
                    orderController.changeAllStatus(status, Status.KHÁCH_ĐÃ_NHẬN_HÀNG);
                    back = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        System.out.println("Thay đổi thành công!");
    }


    // 3. Quản lý sản phẩm
    public void manageProduct() {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    \n---------------------- QUẢN LÝ SẢN PHẨM -----------------------
                    1. Xem toàn bộ sách \t\t 2. Thêm sách \t\t\t 3. Sửa sách  
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
                    \n1. Kiểm tra số lượng sách tồn kho \t\t 2. Sách best seller \t\t 0. Quay lại
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
        printBookHasSold(orderController.getBookHasSold());
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
            System.out.println("\n---------------------- QUẢN LÝ KHÁCH HÀNG -----------------------");
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
            System.out.println("\n---------------------- QUẢN LÝ TÀI KHOẢN -----------------------");
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

    public int getIdOrder() {
        boolean back = false;
        int id = 0;

        while (!back) {
            try {
                System.out.print("Nhập vào id: ");
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            back = true;
        }
        return id;
    }

    // Lấy ra năm theo ko lỗi
    public int getYear() {
        boolean back = false;
        int year = 1;

        while (!back) {
            try {
                System.out.print("Nhập vào năm: ");
                year = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại!");
                continue;
            }
            if (year > 0) {
                back = true;
            } else {
                System.out.println("Không có năm này. Hãy nhập lại!");
            }
        }
        return year;
    }

    public int getMonth() {
        boolean back = false;
        int month = 0;

        while (!back) {
            try {
                System.out.print("Nhập vào tháng: ");
                month = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập lại!");
                continue;
            }
            if (month > 0 && month < 12) {
                back = true;
            } else {
                System.out.println("Không có tháng này. Hãy nhập lại!");
            }
        }
        return month;
    }

    public void printOrders(ArrayList<Order> orders) {
        FileUltils.printOrder(orders);
    }

    public void printBookHasSold(List<Item> items) {
        FileUltils.printBookHasSold(items);
    }

    public String formattingNumber(int num) {
        return FileUltils.formattingDisplay(num);
    }
}
