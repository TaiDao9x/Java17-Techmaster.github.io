package backend.repository;

import backend.database.ItemDatabase;
import backend.model.Item;
import backend.ultils.FileUltils;

import java.util.ArrayList;

public class ItemRepository {
    public ArrayList<Item> findAll() {
        return ItemDatabase.allItems;
    }

    public void updateFile(ArrayList<Item> items) {
        FileUltils.setDataToFile("item.json", items);
    }
}
