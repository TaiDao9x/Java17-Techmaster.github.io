package backend.database;

import backend.model.Item;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class ItemDatabase {
    public static ArrayList<Item> allItems  = FileUltils.getItemDataFromFile("item.json");

}
