package homework_02.controller;

import homework_02.entity.Customer;
import homework_02.handle.CustomerManagement;
import homework_02.statics.CustomerType;

import java.util.Scanner;

public class CustomerController implements AddInfo {
    CustomerManagement customerManagement = new CustomerManagement();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addInfo() {
        System.out.println("Số lượng khách hàng bạn muốn thêm? ");
        int customerNumber = getOption();
        for (int i = 0; i < customerNumber; i++) {
            Customer newCustomer = new Customer();
            System.out.print("Nhập tên khách hàng:");
            newCustomer.setName(sc.nextLine());
            System.out.print("Nhập địa chỉ: ");
            newCustomer.setAddress(sc.nextLine());
            System.out.print("Nhập SĐT: ");
            newCustomer.setPhone(sc.nextLine());
            System.out.println("Loại khách hàng: ");
            System.out.println("1. Cá nhân");
            System.out.println("2. Đại diện đơn vị hành chính");
            System.out.println("3. Đại diện đơn vị kinh doanh");
            int customerType = getCustomerType();
            switch (customerType) {
                case 1 -> newCustomer.setCustomerType(CustomerType.CA_NHAN);
                case 2 -> newCustomer.setCustomerType(CustomerType.DAI_DIEN_DON_VI_HANH_CHINH);
                case 3 -> newCustomer.setCustomerType(CustomerType.DAI_DIEN_DON_VI_KINH_DOANH);
            }
            customerManagement.addNewCustomer(newCustomer);
        }
    }

    @Override
    public void showInfo() {
        customerManagement.allCustomers().forEach(System.out::println);

    }


    public int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option <= 0) {
                    System.out.println("Hãy nhập số lớn hơn 0!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }

    public int getCustomerType() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option <= 0 || option > 3) {
                    System.out.println("Hãy nhập số từ 0 đên 3!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }


}
