package homework_01;

import homework_01.logic_handle.MenuManagement;
import homework_01.logic_handle.WorkerManagement;

public class Main {
    public static void main(String[] args) {
        MenuManagement menuManagement = new MenuManagement();
        WorkerManagement workerManagement = new WorkerManagement();

//        menuManagement.menu();
        workerManagement.inputInfo();
    }


}
