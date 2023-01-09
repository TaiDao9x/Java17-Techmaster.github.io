package backend.service;

import backend.model.Order;
import backend.model.Status;
import backend.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            if (order.getEmail().equalsIgnoreCase(email) && order.getStatus().equals(Status.KHÁCH_ĐÃ_NHẬN_HÀNG)) {
                orders.add(order);
            }
        }
        return orders;
    }

    public List<Order> getOrdersBystatus(Status status) {
        return allOder.stream()
                .filter(order -> order.getStatus().equals(status)).collect(Collectors.toList());
    }

    public void changeStatus(int id, Status status) {
        for (Order order : allOder) {
            if (order.getIdOrder() == id) {
                order.setStatus(status);
            }
        }
        orderRepository.updateFile(allOder);
    }
}