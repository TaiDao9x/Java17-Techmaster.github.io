package backend.repository;

import backend.database.OrderDatabase;
import backend.model.Order;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class OrderRepository {
    public ArrayList<Order> findAll() {
        return OrderDatabase.allOders;
    }

    public void updateFile(ArrayList<Order> allOders) {
        FileUltils.setDataToFile("order.json", allOders);
    }
}
