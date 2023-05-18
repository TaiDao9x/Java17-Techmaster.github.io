package logic_handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {

    private WorkerManagement workerManagement;
    private FactoryManagement factoryManagement;
    private TimeSheetManagement timeSheetManagement;

    public MenuManagement() {
        this.workerManagement = new WorkerManagement();
        this.factoryManagement = new FactoryManagement();
        this.timeSheetManagement = new TimeSheetManagement(workerManagement, factoryManagement);
    }

    public void menu() {
        while (true) {
            printMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    workerManagement.inputInfo();
                    break;
                case 2:
                    // TODO - factoryManagement
                    break;
                case 3:
                    timeSheetManagement.logTimeSheet();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    return;
            }
        }
    }

    private void printMenu() {
        System.out.println("------------PHẦN MỀM QUẢN LÝ TÍNH LƯƠNG CHO CÔNG NHÂN--------------");
        System.out.println("1. Nhập danh sách công nhân mới và in ra màn hình");
        System.out.println("2. Nhập danh sách phân xương mới và in ra màn hình");
        System.out.println("3. Lập bảng tính công cho nhân viên");
        System.out.println("4. Sắp xếp bảng tính công");
        System.out.println("5. Lập bảng kê thu nhập");
        System.out.println("6. Thoát");
        System.out.println("Xin mời chọn chức năng: ");
    }

    private int functionChoice() {
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 6: ");
            }
        } while (true);
        return choice;
    }

}
