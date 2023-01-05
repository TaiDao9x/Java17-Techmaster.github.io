package backend.User.controler;

import backend.User.model.Item;
import backend.User.service.ItemService;

import java.util.ArrayList;

public class ItemController {
    ItemService itemService = new ItemService();

    public void addItemFromIdBook(Item item) {
        itemService.addItemFromIdBook(item);
    }

    public ArrayList<Item> getCart(String email) {

        return itemService.getCart(email);
    }

    public int getTotal(String email) {
        return itemService.getTotal(email);
    }

    public void deleteItemFromCart(int id, String email) {
        itemService.deleteItemFromCart(id,email);
    }

    public boolean checkItemExist(int id, String email) {
        return itemService.checkItemExist(id,email);
    }

    public void changeCount(int id, String email, int count) {
        itemService.changeCount(id,email,count);
    }
}
