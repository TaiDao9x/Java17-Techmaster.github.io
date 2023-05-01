package homework_02.controller;

import homework_02.entity.Service;
import homework_02.handle.ServiceManagement;

import java.util.Scanner;

public class ServiceController implements AddInfo {
    ServiceManagement serviceManagement = new ServiceManagement();
    CustomerController customerController = new CustomerController();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void addInfo() {
        System.out.println("Số lượng dịch vụ bạn muốn thêm? ");
        int serviceNumber = customerController.getOption();
        for (int i = 0; i < serviceNumber; i++) {
            Service service = new Service();
            System.out.print("Nhập tên dịch vụ:");
            service.setName(sc.nextLine());
            System.out.println("Giá cước: ");
            service.setPrice(getPrice());
            System.out.print("Đơn vị tính: ");
            service.setUnit(sc.nextLine());

            serviceManagement.addNewCustomer(service);
        }
    }

    @Override
    public void showInfo() {
        serviceManagement.allServices().forEach(System.out::println);
    }


    public int getPrice() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option < 0) {
                    System.out.println("Giá cước phải lớn hơn 0!");
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