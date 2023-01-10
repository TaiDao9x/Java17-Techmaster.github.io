package backend.service;

import backend.model.Item;
import backend.model.Order;
import backend.model.Status;
import backend.repository.OrderRepository;

import java.util.*;
import java.util.stream.Collectors;

public class OrderService {
    OrderRepository orderRepository = new OrderRepository();
    ArrayList<Order> allOder = orderRepository.findAll();

    BookService bookService = new BookService();


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
        return (ArrayList<Order>) orders.stream().sorted((o1, o2) -> o2.getIdOrder() - o1.getIdOrder()).collect(Collectors.toList());
    }

    public ArrayList<Order> getorderDone(String email) {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email) && order.getStatus().equals(Status.KHÁCH_ĐÃ_NHẬN_HÀNG)) {
                orders.add(order);
            }
        }
        return (ArrayList<Order>) orders.stream().sorted((o1, o2) -> o2.getIdOrder() - o1.getIdOrder()).collect(Collectors.toList());
    }

    public List<Order> getOrdersBystatus(Status status) {
        return allOder.stream().filter(order -> order.getStatus().equals(status)).collect(Collectors.toList());
    }

    public void changeStatus(int id, Status status) {
        for (Order order : allOder) {
            if (order.getIdOrder() == id) {
                order.setStatus(status);
            }
        }
        orderRepository.updateFile(allOder);
    }

    public void changeAllStatus(Status status, Status newStatus) {
        for (Order order : allOder) {
            if (order.getStatus().equals(status)) {
                order.setStatus(newStatus);
            }
        }
        orderRepository.updateFile(allOder);
    }

    public long countOrder(Status status) {
        return allOder.stream().filter(n -> n.getStatus().equals(status)).count();
    }

    public long countAllOrder() {
        return allOder.size();
    }

    public int getRevenueByYear(int year) {
        int revenue = 0;
        for (Order order : allOder) {
            if (Integer.parseInt(order.getDate().substring(6, 10)) == year) {
                revenue += calculateTotal(order);
            }
        }
        return revenue;
    }

    public int calculateTotal(Order order) {
        List<Item> cart = order.getCart();
        return cart.stream().map(item -> item.getCount() * item.getPrice()).mapToInt(a -> a).sum();
    }

    public int getRevenueByMonth(int month, int year) {
        int revenue = 0;
        for (Order order : allOder) {
            if (Integer.parseInt(order.getDate().substring(3, 5)) == month && Integer.parseInt(order.getDate().substring(6, 10)) == year) {
                revenue += calculateTotal(order);
            }
        }
        return revenue;
    }

    // Lấy ra danh sách tất cả sp đã được khách hàng đặt
    public Map<Integer, Integer> getCountBookHasSold() {
        int totalCount = 0;
        Map<Integer, Integer> bookAndCount = new HashMap<>();
        for (int i = 1; i <= bookService.ALL_BOOKS.size(); i++) {
            for (Order order : allOder) {
                List<Item> cart = order.getCart();
                for (Item item : cart) {
                    {
                        if (item.getId() == i) {
                            totalCount += item.getCount();
                        }
                    }
                }
            }
            bookAndCount.put(i, totalCount);
            totalCount = 0;
        }
        return bookAndCount;
    }

    // Danh sách sách bán được đã được sắp xếp số lượng bán giảm dần
    public List<Item> getBookHasSold() {
        Map<Integer, Integer> bookAndCount = getCountBookHasSold();
        List<Item> BookHasSold = new ArrayList<>();

        Set<Integer> set = bookAndCount.keySet();
        for (Integer key : set) {
            Item item = new Item("email@gmail.com", key, bookService.findBookById(key).getTitle(), bookAndCount.get(key), bookService.findBookById(key).getPrice(), (bookAndCount.get(key) * bookService.findBookById(key).getPrice()));
            BookHasSold.add(item);
        }
        return BookHasSold.stream().sorted((o1, o2) -> o2.getCount() - o1.getCount()).limit(10).collect(Collectors.toList());
    }

    public List<Item> reportRevenueByProduct() {
        return getBookHasSold().stream()
                .sorted((o1, o2) -> o2.getCount() * o2.getCount() - o1.getCount() * o1.getCount())
                .collect(Collectors.toList());
    }
}