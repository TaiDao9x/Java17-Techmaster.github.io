package frontend;

import backend.controler.BookControler;
import backend.controler.ItemControler;
import backend.controler.OrderController;
import backend.controler.UserControler;
import backend.model.*;
import backend.ultils.FileUltils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagerOrderUI {
    Scanner sc = new Scanner(System.in);
    UserControler userControler = new UserControler();
    ItemControler itemControler = new ItemControler();
    OrderController orderController = new OrderController();
    BookControler bookControler = new BookControler();

    // 3. Quản lý giỏ hàng
    public void menuCart() {
        System.out.println("""
                \n1. Xóa sản phẩm \t\t 2. Thay đổi số lượng \t\t 3. Mua hàng \t\t 0.Quay lại
                """);
    }

    public void manageCart(String email) {
        boolean back = false;
        while (!back) {
            if (getMyCart(email).size() != 0) {

                System.out.println("\nGiỏ hàng của bạn: ");
                ArrayList<Item> myCart = getMyCart(email);
                printCart(myCart);
                calculateTotal(myCart);

                menuCart();

                int option = getOption();

                switch (option) {
                    case 1 -> deleteItem(email);
                    case 2 -> changeCount(email);
                    case 3 -> checkOrderBook(email);
                    case 0 -> back = true;
                    default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                }
            } else {
                System.out.println("Giỏ hàng trống!");
                back = true;
            }
        }
    }

    // 3.3 Mua hàng (tạo order -> sẽ xóa cart và chuyển sang cho admin duyệt)
    public void checkOrderBook(String email) {
        Order preOrder = createPreorder(email);
        boolean back = false;
        while (!back) {
            System.out.println("\n========================================================================");
            System.out.println("Bạn hãy kiểm tra lại các thông tin trước khi đật hàng! ");
            ArrayList<Item> myCart = getMyCart(email);
            printCart(myCart);
            calculateTotal(myCart);

            System.out.println("\nNgười nhận: " + preOrder.getName() + "\t\tSố điện thoại: " + preOrder.getPhone());
            System.out.print("Địa chỉ: ");
            printAddress(preOrder.getAddress());
            System.out.println("========================================================================");

            System.out.println("\n1. Thay đổi người nhận hàng  \t\t 2. Đặt hàng \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> preOrder = changeReceiverInfo(email);
                case 2 -> {
                    creatOrder(preOrder);
                    back = true;
                }
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // 3.2 Mua hàng
    // Thay đổi thông tin người nhận hàng
    public Order changeReceiverInfo(String email) {
        System.out.print("Tên người nhận hàng: ");
        String name = sc.nextLine();
        String phone = getPhoneToOrder();
        Address address = getAddressToOrder();
        String date = getDateTimeOrder();
        return new Order(getIdOrder(), email, getMyCart(email), name, phone, address, date, Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
    }

    // Tạo preOrder
    public Order createPreorder(String email) {
        return new Order(getIdOrder(), email, getMyCart(email), getUserbyEmail(email).getEmail(), getUserbyEmail(email).getPhone(), getUserbyEmail(email).getAddress(), getDateTimeOrder(), Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
    }

    // Tạo Order
    public void creatOrder(Order order) {
        changeAfterOrder(order);
        deleteCart(order.getEmail());
        orderController.creatOrder(order);
        System.out.println("Bạn đã đặt hàng thành công!");
    }

    public int getIdOrder() {
        return orderController.getIdOrder();
    }

    // Sau khi đặt hàng số lượng trong kho giảm đi
    public void changeAfterOrder(Order order) {
        ArrayList<Item> cart = getMyCart(order.getEmail());
        Map<Integer, Integer> reduceCount = new HashMap<>();
        for (Item item : cart) {
            reduceCount.put(item.getId(), item.getCount());
        }

        bookControler.changeAfterOrder(reduceCount);
    }

    // Xóa giỏ hàng sau khi đặt hàng thành công
    public void deleteCart(String email) {
        itemControler.deleteCart(email);
    }

    // 3.1 Xóa sách trong giỏ
    public void deleteItem(String email) {
        int id = getId();
        if (checkIdInCart(email, id)) {
            itemControler.deleteItem(email, id);
            System.out.println("Đã xóa sản phẩm thành công! ");
        } else {
            System.out.println("Không có sản phẩm trong giỏ hàng!");
        }
    }

    // check xem trong giỏ hàng có sách là id hay ko?
    public boolean checkIdInCart(String email, int id) {
        ArrayList<Item> cart = getMyCart(email);
        for (Item item : cart) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // 3.2 thay đổi số lượng sản phẩm
    public void changeCount(String email) {
        int id = getId();
        int newCount = getCount();
        if (checkIdInCart(email, id)) {
            itemControler.changeCount(email, id, newCount);
        } else {
            System.out.println("Không có sản phẩm trong giỏ hàng!");
        }
    }

    public int getCount() {
        boolean back = false;
        int newCount = 0;

        while (!back) {
            try {
                System.out.print("Nhập số lượng sách bạn muốn đặt: ");
                newCount = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            back = true;
        }
        return newCount;
    }

    // Lấy ra giỏ hàng của email tương ứng
    public ArrayList<Item> getMyCart(String email) {
        return itemControler.getMyCart(email);
    }

    // Tính tổng tiền cần thanh toán
    public void calculateTotal(ArrayList<Item> cart) {
        int rs = cart.stream()
                .map(item -> item.getCount() * item.getPrice())
                .mapToInt(a -> a)
                .sum();
        System.out.println("Tổng giá trị giỏ hàng: " + FileUltils.formattingDisplay(rs));
    }

    // Method thường xuyên sử dụng
    public int getOption() {
        return FileUltils.getOption();
    }

    public int getId() {
        return FileUltils.getId();
    }

    public void printCart(ArrayList<Item> cart) {
        FileUltils.printCart(cart);
    }

    public User getUserbyEmail(String email) {
        return userControler.getUserByEmail(email);
    }

    public String getPhoneToOrder() {
        boolean checkPhoned = false;
        String phone = "";
        while (!checkPhoned) {
            System.out.print("Nhập số điện thoại người nhận hàng: ");
            phone = sc.nextLine();
            if (userControler.checkPhoneValid(phone)) {
                checkPhoned = true;
            } else {
                System.out.println("Số điện không hợp lệ!");
            }
        }
        return phone;
    }

    public Address getAddressToOrder() {
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

    public String getDateTimeOrder() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss"));
    }

    public void printAddress(Address address) {
        System.out.printf("%s, %s, %s, %s\n", address.getDetail(), address.getStreet(), address.getDistrict(), address.getCity());
    }
}