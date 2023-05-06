package entity;

import statics.WorkerLevel;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Worker extends Person {

    private int id;
    private WorkerLevel level;

    private static int AUTO_ID = 1000;


    public Worker() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                ", level=" + level +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();

        System.out.println("Nhập bậc thợ: ");
        System.out.println("1. Bậc 1");
        System.out.println("2. Bậc 2");
        System.out.println("3. Bậc 3");
        System.out.println("4. Bậc 4");
        System.out.println("5. Bậc 5");
        System.out.println("6. Bậc 6");
        System.out.println("7. Bậc 7");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 7) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 7: ");
            }
        } while (true);
        switch (choice) {
            case 1 -> this.setLevel(WorkerLevel.LEVEL_1);
            case 2 -> this.setLevel(WorkerLevel.LEVEL_2);
            case 3 -> this.setLevel(WorkerLevel.LEVEL_3);
            case 4 -> this.setLevel(WorkerLevel.LEVEL_4);
            case 5 -> this.setLevel(WorkerLevel.LEVEL_5);
            case 6 -> this.setLevel(WorkerLevel.LEVEL_6);
            case 7 -> this.setLevel(WorkerLevel.LEVEL_7);
        }
    }

}
