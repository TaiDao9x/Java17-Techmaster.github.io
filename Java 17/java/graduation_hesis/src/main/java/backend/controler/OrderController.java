package backend.controler;

import backend.model.Order;
import backend.service.OrderService;

import java.util.ArrayList;

public class OrderController {
    OrderService orderService = new OrderService();

    public void creatOrder(Order order) {
        orderService.creatOrder(order);
    }

    public int getIdOrder() {
        return orderService.getIdOrder();
    }

    public ArrayList<Order> getOrders(String email) {
        return orderService.getOrders(email);
    }

    public ArrayList<Order> getorderDone(String email) {
        return orderService.getorderDone(email);
    }
}
