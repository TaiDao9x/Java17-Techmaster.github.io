package backend.User.repository;

import backend.User.database.ItemDatabase;
import backend.User.model.Item;
import backend.User.ultils.ItemFileUltils;

import java.util.ArrayList;

public class ItemRepository {
    public ArrayList<Item> findAllItem() {
        return ItemDatabase.items();
    }

    public void updateFile(ArrayList<Item> items) {
        ItemFileUltils.setDataToFile("item.json", items);
    }
}
