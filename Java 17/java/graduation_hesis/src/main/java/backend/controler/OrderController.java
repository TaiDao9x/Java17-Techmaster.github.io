package backend.controler;

import backend.model.Item;
import backend.model.Order;
import backend.model.Status;
import backend.service.OrderService;

import java.util.ArrayList;
import java.util.List;

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

    public ArrayList<Order> getorderDone(String email, Status status) {
        return orderService.getorderDone(email,status);
    }

    public List<Order> getOrdersBystatus(Status status) {
        return orderService.getOrdersBystatus(status);
    }

    public void changeStatus(int id, Status status) {
        orderService.changeStatus(id, status);
    }

    public void changeAllStatus(Status status, Status newStatus) {
        orderService.changeAllStatus(status, newStatus);
    }

    public long countOrder(Status status) {
        return orderService.countOrder(status);
    }

    public long countAllOrder() {
        return orderService.countAllOrder();
    }

    public int getRevenueByYear(int year) {
        return orderService.getRevenueByYear(year);
    }

    public int getRevenueByMonth(int month, int year) {
        return orderService.getRevenueByMonth(month, year);
    }

    public List<Item> getBookHasSold() {
        return orderService.getBookHasSold();
    }

    public List<Item> reportRevenueByProduct() {
        return orderService.reportRevenueByProduct();
    }

    public boolean checkIdOrderExist(int idOrder, String email) {
        return orderService.checkIdOrderExist(idOrder, email);
    }

    public boolean checkIdOrderEnableCancel(int idOrder, String email) {
        return orderService.checkIdOrderEnableCancel(idOrder, email);
    }

    public void cancelOrderYes(String email, int idOrder) {
        orderService.cancelOrderYes(email, idOrder);
    }
}
