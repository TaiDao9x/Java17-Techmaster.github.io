package backend.User.database;

import backend.User.model.Cart;
import backend.User.model.Item;
import backend.User.ultils.ItemFileUltils;

import java.util.ArrayList;

public class CartDatabase {
    public static ArrayList<Item> items() {
        return ItemFileUltils.getDataFromFile("item.json");
    }

    public static Cart cart() {
        return new Cart(items());
    }

}
