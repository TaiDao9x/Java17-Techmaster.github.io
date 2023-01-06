package backend.User.repository;

import backend.User.database.PreOderDatabase;
import backend.User.model.Address;
import backend.User.model.Item;
import backend.User.model.Order;
import backend.User.ultils.ItemFileUltils;
import backend.User.ultils.PreOrderFileUltils;

import java.util.ArrayList;

public class PreOrderRepository {

    public static ArrayList<Order> findAllOrder() {
        return PreOderDatabase.preOrder();
    }
    public static void updateFile(ArrayList<Order> preOrder) {
        ItemFileUltils.setDataToFile("pre_order.json", preOrder);
    }

}
