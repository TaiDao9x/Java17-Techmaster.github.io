package backend.service;

import backend.model.Item;
import backend.model.Order;
import backend.model.Status;
import backend.repository.BookRepository;
import backend.repository.OrderRepository;
import backend.ultils.FileUltils;

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

    public ArrayList<Order> getorderByStatus(String email, Status status) {
        ArrayList<Order> orders = new ArrayList<>();
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email) && order.getStatus().equals(status)) {
                orders.add(order);
            }
        }
        return (ArrayList<Order>) orders.stream().sorted((o1, o2) -> o2.getIdOrder() - o1.getIdOrder()).collect(Collectors.toList());
    }

    // TODO: trung ten method
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
            if (Integer.parseInt(order.getDate().substring(6, 10)) == year && order.getStatus().equals(Status.KHÁCH_ĐÃ_NHẬN_HÀNG)) {
                revenue += calculateTotal(order);
            }
        }
        return revenue;
    }

    public int getRevenueByMonth(int month, int year) {
        int revenue = 0;
        for (Order order : allOder) {
            if (Integer.parseInt(order.getDate().substring(3, 5)) == month && Integer.parseInt(order.getDate().substring(6, 10)) == year && order.getStatus().equals(Status.KHÁCH_ĐÃ_NHẬN_HÀNG)) {
                revenue += calculateTotal(order);
            }
        }
        return revenue;
    }

    public int calculateTotal(Order order) {
        List<Item> cart = order.getCart();
        return cart.stream().map(item -> item.getCount() * item.getPrice()).mapToInt(a -> a).sum();
    }

    // Lấy ra danh sách tất cả sp đã được khách hàng đặt
    public Map<Integer, Integer> getCountBookHasSold() {
        int totalCount = 0;
        Map<Integer, Integer> bookAndCount = new HashMap<>();
        for (int i = 1; i <= bookService.ALL_BOOKS.size(); i++) {
            for (Order order : allOder) {
                if (order.getStatus().equals(Status.KHÁCH_ĐÃ_NHẬN_HÀNG)) {
                    List<Item> cart = order.getCart();
                    for (Item item : cart) {
                        {
                            if (item.getId() == i) {
                                totalCount += item.getCount();
                            }
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
        return getBookHasSold().stream().sorted((o1, o2) -> o2.getCount() * o2.getCount() - o1.getCount() * o1.getCount()).collect(Collectors.toList());
    }

    public boolean checkIdOrderExist(int idOrder, String email) {
        return allOder.stream().anyMatch(n -> n.getEmail().equalsIgnoreCase(email) && n.getIdOrder() == idOrder && (n.getStatus().equals(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN) || n.getStatus().equals(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG) || n.getStatus().equals(Status.ĐANG_GIAO_HÀNG)));
    }

    public boolean checkIdOrderEnableCancel(int idOrder, String email) {
        return allOder.stream().anyMatch(n -> n.getEmail().equalsIgnoreCase(email) && n.getIdOrder() == idOrder && (n.getStatus().equals(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN) || n.getStatus().equals(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG)));
    }

    public void cancelOrderYes(String email, int idOrder) {
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email) && order.getIdOrder() == idOrder && (order.getStatus().equals(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN) || order.getStatus().equals(Status.NGƯỜI_BÁN_ĐANG_CHUẨN_BỊ_HÀNG))) {
                order.setStatus(Status.ĐƠN_ĐÃ_HỦY);
            }
        }
        orderRepository.updateFile(allOder);
    }

    public void updateCountAfterCancel(String email, int idOrder) {
        for (Order order : allOder.stream().filter(n -> n.getIdOrder() == idOrder).toList()) {
            List<Item> cart = order.getCart();
            for (Item item : cart) {
                bookService.updateQuantity(item.getId(), (bookService.getCurrentQuanity(item.getId()) + item.getCount()));
            }
        }
    }

    public List<Order> countAllOrderByEmail(String email) {
        return allOder.stream().filter(n -> n.getEmail().equalsIgnoreCase(email)).collect(Collectors.toList());
    }


    public boolean checkIdOrderEnableReOrder(String email, int idOrder, Status status) {
        return allOder.stream()
                .anyMatch(n -> (n.getEmail().equalsIgnoreCase(email) && n.getIdOrder() == idOrder && n.getStatus().equals(status)));
    }

    public void reOrderYes(String email, int idOrder) {
        for (Order order : allOder) {
            if (order.getEmail().equalsIgnoreCase(email) && order.getIdOrder() == idOrder) {
                order.setDate(FileUltils.getDate());
                order.setStatus(Status.CHỜ_NGƯỜI_BÁN_XÁC_NHẬN);
            }
        }
        orderRepository.updateFile(allOder);
    }

    public Order getOrdersById(int idOrder) {
        Order order = new Order();
        for (Order o : allOder) {
            if (o.getIdOrder() == idOrder) {
                order = o;
            }
        }
        return order;
    }
}