package logic_handle;

import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class WorkerManagement {

    private List<Worker> workers;

    public WorkerManagement() {
        this.workers = new ArrayList<>();
    }

    public void inputInfo() {
        System.out.println("Bạn muốn nhập cho bao nhiêu công nhân: ");
        int workerNumber;
        do {
            try {
                workerNumber = new Scanner(System.in).nextInt();
                if (workerNumber > 0) {
                    break;
                }
                System.out.println("Số lượng công nhân nhập vào phải lơn hơn 0, nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);

        for (int i = 0; i < workerNumber; i++) {
            Worker worker = new Worker();
            worker.inputInfo();
            workers.add(worker);
        }
        showWorker();
    }

    public void showWorker() {
//        for (int i = 0; i < workers.size(); i++) {
//            System.out.println(workers.get(i));
//        }

        workers.forEach(System.out::println);
    }

    public Worker findById(int id) {
        for (int i = 0; i < workers.size(); i++) {
            if (workers.get(i).getId() == id) {
                return workers.get(i);
            }
        }
        return null;
    }

}
