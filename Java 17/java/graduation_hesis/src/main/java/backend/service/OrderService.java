package backend.service;

import backend.model.Order;
import backend.model.Status;
import backend.repository.OrderRepository;

import java.util.ArrayList;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();
    ArrayList<Order> allOder = orderRepository.findAll();


    public void creatOrder(Order order) {
        allOder.add(order);
        orderRepository.updateFile(allOder);
    }

    public int getIdOrder() {
        int max = 0;
        for (Order order : allOder) {
            if (order.getIdOrder() > max) {
                max = order.getIdOrder();
            }
        }
        return max + 1;
    }

    public ArrayList<Order> getOrders(String email) {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email)) {
                if (order.getStatus().equals(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN) || order.getStatus().equals(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG) || order.getStatus().equals(Status.ĐANG_GIAO_HÀNG)) {
                    orders.add(order);
                }
            }
        }
        return orders;
    }

    public ArrayList<Order> getorderDone(String email) {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email) && order.getStatus().equals(Status.ĐÃ_NHẬN_HÀNG)) {
                orders.add(order);
            }
        }
        return orders;
    }
}
