package logic_handle;

import entity.Factory;
import entity.Worker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FactoryManagement {

    private List<Factory> factories;

    public FactoryManagement() {
        this.factories = new ArrayList<>();
    }

    public void inputInfo() {
//        System.out.println("Bạn muốn nhập cho bao nhiêu công nhân: ");
//        int workerNumber;
//        do {
//            try {
//                workerNumber = new Scanner(System.in).nextInt();
//                if (workerNumber > 0) {
//                    break;
//                }
//                System.out.println("Số lượng công nhân nhập vào phải lơn hơn 0, nhập lại: ");
//            } catch (InputMismatchException ex) {
//                System.out.println("Vui lòng nhập số: ");
//            }
//        } while (true);
//
//        for (int i = 0; i < workerNumber; i++) {
//            Worker worker = new Worker();
//            worker.inputInfo();
//            workers.add(worker);
//        }
//        showWorker();
    }

//    public void showWorker() {
////        for (int i = 0; i < workers.size(); i++) {
////            System.out.println(workers.get(i));
////        }
//
//        workers.forEach(System.out::println);
//    }

    public Factory findById(int id) {
        for (int i = 0; i < factories.size(); i++) {
            if (factories.get(i).getId() == id) {
                return factories.get(i);
            }
        }
        return null;
    }

}
