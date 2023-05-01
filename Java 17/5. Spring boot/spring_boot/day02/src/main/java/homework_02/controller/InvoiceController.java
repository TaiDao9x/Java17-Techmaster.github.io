package homework_02.controller;

import homework_02.entity.InvoiceDetail;
import homework_02.entity.Service;
import homework_02.handle.CustomerManagement;
import homework_02.handle.ServiceManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoiceController {
    private Scanner sc = new Scanner(System.in);
    CustomerController customerController = new CustomerController();
    CustomerManagement customerManagement = new CustomerManagement();
    ServiceManagement serviceManagement = new ServiceManagement();

    public void addInvoice() {
        System.out.println("Bạn muốn viết hóa đơn cho bao nhiêu khách hàng?");
        List<InvoiceDetail> invoiceDetails = new ArrayList<>();
        int invoiceDetailNumber = customerController.getOption();
        for (int i = 0; i < invoiceDetailNumber; i++) {
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setCustomer(customerManagement.getCustomer(getCustomerId()));
            System.out.print("Số lượng dịch vụ khách hàng này sử dụng:");
            int numberService = serviceNumber();
            List<Service> services = new ArrayList<>();
            for (int j = 0; j < numberService; j++) {
                System.out.println("Nhập id dịch vụ thứ " + (i + 1) + " :");
                services.add(getService());
            }
            invoiceDetail.setServices(services);
            invoiceDetails.add(invoiceDetail);
        }
        for (InvoiceDetail iv : invoiceDetails) {
            System.out.println(iv);
        }
    }

    public int getCustomerId() {
        boolean checkOption = false;
        int id = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập id khách hàng:");
                id = Integer.parseInt(sc.nextLine());
                if (id <= 0) {
                    System.out.println("Id có 5 chữ số lớn hơn 0!");
                    continue;
                }
                if (!customerManagement.checkIdExist(id)) {
                    System.out.println("Id khách hàng không tồn tại!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return id;
    }

    public int serviceNumber() {
        boolean checkOption = false;
        int number = 0;
        while (!checkOption) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number <= 0 || number > 5) {
                    System.out.println("1 khách hàng chỉ được sử dụng tối đa 5 dịch vụ");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return number;
    }

    public Service getService() {
        boolean checkOption = false;
        int id = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập id dịch vụ:");
                id = Integer.parseInt(sc.nextLine());
                if (id <= 0) {
                    System.out.println("Id có 3 chữ số lớn hơn 0!");
                    continue;
                }
                if (serviceManagement.findServiceId(id) == null) {
                    System.out.println("Dịch vụ không tồn tại!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return serviceManagement.findServiceId(id);
    }
}
