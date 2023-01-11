package frontend;

import backend.controler.BookControler;
import backend.controler.ItemControler;
import backend.controler.OrderController;
import backend.controler.UserControler;
import backend.model.*;
import backend.request.UserRequest;
import backend.ultils.FileUltils;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientUi {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    BookControler bookControler = new BookControler();
    ManagerOrderUI managerOrderUI = new ManagerOrderUI();
    ItemControler itemControler = new ItemControler();
    OrderController orderController = new OrderController();

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
                    System.out.println("\n----------- XEM SÁCH -----------");

                    ArrayList<Book> books = showBook();
                    if (books.size() != 0) {
                        printBook(books);
                        choseToCart(clientLogin, books);
                    }
                }
                case 2 -> {
                    System.out.println("\n----------- TÌM SÁCH -----------");

                    ArrayList<Book> books = findBook();
                    if (books.size() != 0) {
                        printBook(books);
                        choseToCart(clientLogin, books);
                    } else {
                        System.out.println("Kết quả tìm kiếm không có!");
                    }
                }
                case 3 -> {
                    System.out.println("\n----------- GIỎ HÀNG -----------");
                    managerOrderUI.manageCart(clientLogin.getEmail());
                }
                case 4 -> {
                    System.out.println("\n----------- LỊCH SỬ MUA HÀNG -----------");
                    orderHistory(clientLogin.getEmail());
                }
                case 5 -> {
                    System.out.println("\n----------- THÔNG TIN CÁ NHÂN -----------");
                    updateInfo(clientLogin.getEmail());
                }
                case 0 -> {
                    System.out.println("\n----------- HẸN GẶP LẠI! -----------");
                    isQuitLogin = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }


    // TẦNG SHOW DỮ LIỆU (lv3, lv4)
    // 1. Xem danh sách sản phẩm

    public ArrayList<Book> showBook() {
        ArrayList<Book> books = new ArrayList<>();
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    \n1. Xem toàn bộ sách \t\t 2. Xem theo thể loại \t\t 3. Xem theo nhà xuất bản\t\t0. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    books = (ArrayList<Book>) bookControler.showAllBook();

                    backToMenu = true;
                }
                case 2 -> {
                    books = showBookByCategory();
                    backToMenu = true;
                }
                case 3 -> {
                    books = showBookByPulisherCompany();
                    backToMenu = true;
                }
                case 0 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return books;
    }

    // Đưa ra lựa chọn cho khách hàng sau khi xem sách
    public void choseToCart(User client, ArrayList<Book> books) {
        boolean back = false;
        while (!back) {
            System.out.println("\n1. Thêm sách vào giỏ hàng \t\t 2. Đến giỏ hàng \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> addToCart(client.getEmail(), books);
                case 2 -> managerOrderUI.manageCart(client.getEmail());
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // Thêm sách vào giỏ hàng
    public void addToCart(String email, ArrayList<Book> books) {
        int id = getId();
        if (checkIdExist(id, books)) {
            if (checkBookInCart(email, id)) {
                System.out.println("\nSản phẩm này đã có sẵn trong giỏ hàng!");
                System.out.println("Hãy chọn sản phẩm khác hoặc đến giỏ hàng!");
            } else if (bookControler.findBookById(id).getQuantity() <= 0) {
                System.out.println("\nRất tiếc! Sản phẩm này đã cháy hàng!");
            } else {
                Book book = bookControler.findBookById(id);
                Item item = new Item(email, id, book.getTitle(), 1, book.getPrice(), book.getPrice());
                itemControler.addItem(item);
                System.out.println("\nĐã thêm sản phẩm vào giỏ hàng!");
            }
        } else {
            System.out.println("Không có sản phẩm nào trùng id");
        }
    }

    // check id trong kết quả trả về (do KH chọn xem hay tìm trước đó)
    public boolean checkIdExist(int id, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // Kiểm tra xem trong giỏ hàng đã có sách mà khách hàng chọn hay ko? Nếu có thì thông báo đã có, nếu chưa thì thêm sách vào giỏ
    public boolean checkBookInCart(String email, int id) {
        return managerOrderUI.getMyCart(email).stream().anyMatch(item -> item.getId() == id);
    }

    // 1.1. Xem theo thể loại
    public void listCategory() {

        System.out.println("""
                \n1. Tiểu thuyết\t2. Kinh doanh\t\t3. Hướng nghiệp\t\t\t4. Kinh tế\t\t5. Văn học
                6. Self-help\t7. Nuôi dạy con\t\t8. Tiểu sử - Hồi ký\t\t9. Lịch sử\t\t10. Khoa học
                """);
    }

    // Trả về list sách theo thể loại khi đã lấy được dữ liệu loại sách muốn tìm
    public ArrayList<Book> showBookByCategory() {
        boolean backToMenu = false;
        String category = " ";

        while (!backToMenu) {
            listCategory();

            int option = getOption();

            switch (option) {
                case 1 -> {
                    category = "Tiểu thuyết";
                    backToMenu = true;
                }
                case 2 -> {
                    category = "Kinh doanh";
                    backToMenu = true;
                }
                case 3 -> {
                    category = "Hướng nghiệp";
                    backToMenu = true;
                }
                case 4 -> {
                    category = "Kinh tế";
                    backToMenu = true;
                }
                case 5 -> {
                    category = "Văn học";
                    backToMenu = true;
                }
                case 6 -> {
                    category = "Self-help";
                    backToMenu = true;
                }
                case 7 -> {
                    category = "Nuôi dạy con";
                    backToMenu = true;
                }
                case 8 -> {
                    category = "Tiểu sử - Hồi ký";
                    backToMenu = true;
                }
                case 9 -> {
                    category = "Lịch sử";
                    backToMenu = true;
                }
                case 10 -> {
                    category = "Khoa học";
                    backToMenu = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return bookControler.showBookByCategory(category);
        // todo:........ bị return về tất cả sách
    }

    // 1.2. Xem danh sách sản phẩm theo nhà xuất bản
    public void listPushlisherCompany() {
        System.out.println("""
                \n1. NXB trẻ
                2. NXB Thế giới
                3. NXB Lao Động
                4. NXB Dân trí
                5. NXB Văn học
                """);
    }

    public ArrayList<Book> showBookByPulisherCompany() {
        boolean backToMenu = false;
        String pulisherCompany = " ";

        while (!backToMenu) {
            listPushlisherCompany();

            int option = getOption();

            switch (option) {
                case 1 -> {
                    pulisherCompany = "trẻ";
                    backToMenu = true;
                }
                case 2 -> {
                    pulisherCompany = "Thế giới";
                    backToMenu = true;
                }
                case 3 -> {
                    pulisherCompany = "Lao Động";
                    backToMenu = true;
                }
                case 4 -> {
                    pulisherCompany = "Dân trí";
                    backToMenu = true;
                }
                case 5 -> {
                    pulisherCompany = "Văn học";
                    backToMenu = true;
                }
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return bookControler.showBookByPulisherCompany(pulisherCompany);
    }

    // 2. Tìm kiếm sản phẩm
    public ArrayList<Book> findBook() {
        ArrayList<Book> books = new ArrayList<>();
        boolean backToMenu = false;

        while (!backToMenu) {
            System.out.println("""
                    \n1. Tìm theo tên sách \t\t 2. Tìm theo tên tác giả \t\t 0. Quay lại
                    """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    books = findBookByName();
                    backToMenu = true;
                }
                case 2 -> {
                    books = findBookByAuthor();
                    backToMenu = true;
                }
                case 0 -> backToMenu = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
        return books;
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

    // 4. Lịch sử mua hàng
    public void orderHistory(String email) {
        boolean back = false;
        while (!back) {
            System.out.println("\t\t- Tổng số đơn: " + countAllOrderByEmail(email));
            System.out.println("\t\t- Đơn chờ xác nhận: " + countOrder(email, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN));
            System.out.println("\t\t- Đơn đang chuẩn bị: " + countOrder(email, Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG));
            System.out.println("\t\t- Đơn đang giao: " + countOrder(email, Status.ĐANG_GIAO_HÀNG));
            System.out.println("\t\t- Đơn đã hoàn thành: " + countOrder(email, Status.KHÁCH_ĐÃ_NHẬN_HÀNG));
            System.out.println("\t\t- Đơn khách đã hủy: " + countOrder(email, Status.ĐƠN_ĐÃ_HỦY));
            System.out.printf("\n1. Theo dõi đơn hàng (%d)\t\t2. Hủy đơn hàng\t\t 3. Đơn đã mua (%d)\t\t4. Đơn đã hủy (%d)\t\t 0. Quay lại\n"
                    , countOrder(email, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN) + countOrder(email, Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG) + countOrder(email, Status.ĐANG_GIAO_HÀNG)
                    , countOrder(email, Status.KHÁCH_ĐÃ_NHẬN_HÀNG), countOrder(email, Status.ĐƠN_ĐÃ_HỦY));

            int option = getOption();

            switch (option) {
                case 1 -> orderTracking(email);
                case 2 -> cancelOrder(email);
                case 3 -> showOrderDone(email, Status.KHÁCH_ĐÃ_NHẬN_HÀNG);
                case 4 -> showOrderDone(email, Status.ĐƠN_ĐÃ_HỦY);
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    //4.1 Theo dõi đơn hàng
    public void orderTracking(String email) {
        if (getOrders(email).size() > 0) {
            printOrder(getOrders(email));
        } else {
            System.out.println("Không có đơn hàng nào!");
        }
    }

    public ArrayList<Order> getOrders(String email) {
        return orderController.getOrders(email);
    }

    // Đếm tổng số đơn hàng
    public int countAllOrderByEmail(String email) {
        return orderController.countAllOrderByEmail(email).size();
    }

    // Đếm số đơn hàng của từng status
    public int countOrder(String email, Status status) {
        return orderController.getorderByStatus(email, status).size();
    }

    // 4.2 Hủy đơn hàng
    public void cancelOrder(String email) {
        boolean back = false;
        while (!back) {
            System.out.println("""
                    \nBạn muốn hủy đơn hàng:
                     1. Có \t\t 2. Không \t\t 0. Quay lại
                     """);

            int option = getOption();

            switch (option) {
                case 1 -> {
                    if (getorderByStatus(email, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN).size() > 0 || getorderByStatus(email, Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG).size() > 0 || getorderByStatus(email, Status.ĐANG_GIAO_HÀNG).size() > 0) {
                        cancelOrderYes(email);
                    } else {
                        System.out.println("Bạn không có đơn hàng nào để hủy!");
                        back = true;
                    }
                }
                case 2, 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // Quyết định hủy đơn
    public void cancelOrderYes(String email) {
        int idOrder = getIdOrder(email);
        if (orderController.checkIdOrderEnableCancel(idOrder, email)) {
            orderController.cancelOrderYes(email, idOrder);
            updateCountAfterCancel(email, idOrder);
            System.out.println("\nĐã hủy đơn hàng thành công!");
            System.out.println("Chúc bạn tìm được cuốn sách ưng ý!\n");
        } else {
            System.out.println("\nRất tiếc! Đơn đang giao không thể hủy.");
        }
    }

    public int getIdOrder(String email) {
        boolean back = false;
        int idOrder = 0;

        while (!back) {
            try {
                System.out.print("Nhập vào id đơn hàng bạn muốn hủy: ");
                idOrder = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            if (orderController.checkIdOrderExist(idOrder, email)) {
                back = true;
            } else {
                System.out.println("Không có id đơn hàng trên!");
                back = true;
            }
        }
        return idOrder;
    }

    //Update lại số hàng trong kho sau khi hủy đơn
    public void updateCountAfterCancel(String email, int idOrder) {
        orderController.updateCountAfterCancel(email, idOrder);
    }

    // 4.3 Show đơn hàng đã hoàn thành và đã hủy
    public void showOrderDone(String email, Status status) {
        if (getorderByStatus(email, status).size() > 0) {
            printOrder(getorderByStatus(email, status));
        } else {
            System.out.println("Không có đơn hàng nào!");
        }
    }

    // Lấy ra đơn đã hoàn thành và đã hủy
    public ArrayList<Order> getorderByStatus(String email, Status status) {
        return orderController.getorderByStatus(email, status);
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

    // Method phụ
    public int getOption() {
        return FileUltils.getOption();
    }

    public int getId() {
        return FileUltils.getId();
    }

    public void printBook(ArrayList<Book> books) {
        FileUltils.printBook(books);
    }

    public void printOrder(ArrayList<Order> orders) {
        FileUltils.printOrder(orders);
    }

}
