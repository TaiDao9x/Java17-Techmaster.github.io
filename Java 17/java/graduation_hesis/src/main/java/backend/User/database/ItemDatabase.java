package backend.User.database;

import backend.User.model.Item;
import backend.User.ultils.ItemFileUltils;

import java.util.ArrayList;

public class ItemDatabase {
    public static ArrayList<Item> items() {
        return ItemFileUltils.getDataFromFile("item.json");
    }
}
