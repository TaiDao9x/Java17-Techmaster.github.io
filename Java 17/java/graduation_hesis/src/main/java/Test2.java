import backend.model.Order;
import backend.service.OrderService;
import backend.ultils.FileUltils;
import com.sun.tools.javac.Main;
import frontend.ManagerOrderUI;

import java.io.Console;
import java.io.IOError;
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
        Console c = System.console();
        if(c==null){
            System.out.println("no console");
            return;
        }

        try
        {
            char[] pw=c.readPassword("pw: ");
        }catch (IOError ioe){
            System.out.println("no");
        }

    }


}