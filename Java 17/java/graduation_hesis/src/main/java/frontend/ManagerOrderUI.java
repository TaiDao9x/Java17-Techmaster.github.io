package frontend;

import backend.controler.BookControler;
import backend.controler.ItemControler;
import backend.model.Book;
import backend.model.Item;
import backend.model.User;
import backend.ultils.FileUltils;

public class ManagerOrderUI {
    BookControler bookControler = new BookControler();
    ItemControler itemControler = new ItemControler();

    // 3. Quản lý giỏ hàng
    // Sau khi tìm hoặc xem danh sách sản phẩm, sẽ cho khách lựa chọn
    public void choseToCart(User client) {
        boolean back = false;
        while (!back) {
            System.out.println("\n1. Thêm sách vào giỏ hàng \t\t 2. Đến giỏ hàng \t\t 0. Quay lại");

            int option = getOption();

            switch (option) {
                case 1 -> addToCart(client.getEmail());
//    todo:            case 2 -> changePassword(email);
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    // Thêm sách vào giỏ hàng
    public void addToCart(String email) {
        int id = getId();
        Book book = bookControler.findBookById(id);
        Item item = new Item(email, id, book.getTitle(), 1, book.getPrice(), book.getPrice());
        itemControler.addItem(item);
    }

    public void menuCart(){
        System.out.println("""
                \n1. Xóa sản phẩm \t\t 2. Thay đổi số lượng \t\t 3. Mua hàng \t\t 0.Quay lại
                """);
    }

    public void manageCart(String email){
        boolean back = false;
        while (!back) {

            int option = getOption();

            switch (option) {
                case 1 -> {}
                case 0 -> back = true;
                default -> System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
            }
        }
    }

    public int getOption() {
        return FileUltils.getOption();
    }

    public int getId() {
        return FileUltils.getId();
    }
}