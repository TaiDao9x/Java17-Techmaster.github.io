package backend.controler;

import backend.model.Item;
import backend.service.ItemService;

import java.util.ArrayList;

public class ItemControler {
    private final ItemService itemService = new ItemService();

    public void addItem(Item item) {
        itemService.addItem(item);
    }

    public ArrayList<Item> getMyCart(String email) {
        return itemService.getMyCart(email);
    }

    public void deleteItem(String email, int id) {
        itemService.deleteItem(email, id);
    }

    public void changeCount(String email, int id, int newCount) {
        itemService.changeCount(email, id, newCount);
    }

    public void deleteCart(String email) {
        itemService.deleteCart(email);
    }
}
