package homework_02.controller;

import java.util.Scanner;

public class MenuController {
    CustomerController customerController = new CustomerController();
    ServiceController serviceController = new ServiceController();
    InvoiceController invoiceController = new InvoiceController();

    private Scanner sc = new Scanner(System.in);


    public void runMenu() {
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            int choice = customerController.getOption();
            switch (choice) {
                case 1:
                    customerController.addInfo();
                    customerController.showInfo();
                    break;
                case 2:
                    serviceController.addInfo();
                    serviceController.showInfo();
                    break;
                case 3:
                    invoiceController.addInvoice();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    isQuit = true;
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại. Hãy nhập lại!");
                    break;
            }

        }
    }

    private void showMenu() {
        System.out.println("----------------- PHẦN MỀM QUẢN LÝ KHÁCH HÀNG --------------");
        System.out.println("1. Nhập danh sách khách hàng. In ra danh sách khách hàng.");
        System.out.println("2. Nhập danh sách dịch vụ. In ra danh sách dịch vụ.");
        System.out.println("3. Nhập hóa đơn cho mỗi khách hàng.");
        System.out.println("4. Sắp xếp danh sách hóa đơn.");
        System.out.println("5. Lập bảng kê số tiền phải trả.");
        System.out.println("0. Thoát");
    }

}
