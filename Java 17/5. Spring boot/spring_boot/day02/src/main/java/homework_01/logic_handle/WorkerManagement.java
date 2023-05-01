package homework_01.logic_handle;

import homework_01.entity.Worker;
import homework_01.statics.WorkerLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkerManagement {
    private Scanner sc = new Scanner(System.in);

    private List<Worker> workers = new ArrayList<>();

    public void inputInfo() {
        System.out.println("\nBạn muốn thêm bao nhiêu công nhân?");
        int workerNumber = getOption();
        for (int i = 0; i < workerNumber; i++) {
            Worker worker = new Worker();
            System.out.print("Nhập tên công nhân: ");
            worker.setName(sc.nextLine());

            System.out.print("Nhập địa chỉ: ");
            worker.setAddress(sc.nextLine());

            System.out.print("Nhập số điện thoại: ");
            worker.setPhone(sc.nextLine());

            System.out.println("Nhập bậc thợ: ");
            showWorkerLevel();
            int level = getWorkerLevel();
            switch (level) {
                case 1 -> worker.setLevel(WorkerLevel.LEVEL_1);
                case 2 -> worker.setLevel(WorkerLevel.LEVEL_2);
                case 3 -> worker.setLevel(WorkerLevel.LEVEL_3);
                case 4 -> worker.setLevel(WorkerLevel.LEVEL_4);
                case 5 -> worker.setLevel(WorkerLevel.LEVEL_5);
                case 6 -> worker.setLevel(WorkerLevel.LEVEL_6);
                case 7 -> worker.setLevel(WorkerLevel.LEVEL_7);
            }
            workers.add(worker);
            System.out.println("đã thêm công nhân thứ " + i + " vào danh sách!\n");
        }
        showWorkers();
    }

    private void showWorkers() {
        workers.forEach(System.out::println);
    }

    private void showWorkerLevel() {
        System.out.println("1. Bậc 1");
        System.out.println("2. Bậc 2");
        System.out.println("3. Bậc 3");
        System.out.println("4. Bậc 4");
        System.out.println("5. Bậc 5");
        System.out.println("6. Bậc 6");
        System.out.println("7. Bậc 7");
    }

    private int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option <= 0) {
                    System.out.println("Số nhập vào phải lớn hơn 0. Hãy nhập lại!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập số!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }

    private int getWorkerLevel() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
                if (option <= 0 || option > 7) {
                    System.out.println("Số nhập vào phải trong khoảng từ 1 đến 7. Hãy nhập lại!");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy nhập số!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }
}
