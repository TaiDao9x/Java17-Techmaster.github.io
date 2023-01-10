import backend.model.Order;
import backend.service.OrderService;
import backend.ultils.FileUltils;
import frontend.ManagerOrderUI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test2 {
    static ManagerOrderUI managerOrderUI = new ManagerOrderUI();
    static OrderService orderService = new OrderService();

    public static void main(String[] args) {
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);
//
//        String date = localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss"));
//        System.out.println(date);

        System.out.println(Integer.parseInt(orderService.test())==1);
        System.out.println(orderService.getRevenueByYear(2023));

    }
}