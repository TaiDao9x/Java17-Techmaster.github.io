package backend.User.database;

import backend.User.model.Order;
import backend.User.ultils.PreOrderFileUltils;

import java.util.ArrayList;

public class PreOderDatabase {
    public static ArrayList<Order> preOrder() {
        return PreOrderFileUltils.getDataFromFile("pre_order.json");
    }
}
