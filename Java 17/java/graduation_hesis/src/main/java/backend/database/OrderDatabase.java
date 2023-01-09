package backend.database;

import backend.model.Order;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class OrderDatabase {
    public static ArrayList<Order> allOders = FileUltils.getOrderDataFromFile("order.json");

}
