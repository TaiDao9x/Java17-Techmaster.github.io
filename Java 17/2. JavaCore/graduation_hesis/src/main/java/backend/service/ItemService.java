package backend.service;

import backend.model.Item;
import backend.repository.ItemRepository;

import java.util.ArrayList;

public class ItemService {
    private final ItemRepository itemRepository = new ItemRepository();
    ArrayList<Item> ALL_ITEMS = itemRepository.findAll();

    public void addItem(Item item) {
        ALL_ITEMS.add(item);
        itemRepository.updateFile(ALL_ITEMS);
    }

    public ArrayList<Item> getMyCart(String email) {
        ArrayList<Item> myCart = new ArrayList<>();
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email)) {
                myCart.add(item);
            }
        }
        return myCart;
    }

    public void deleteItem(String email, int id) {
        ALL_ITEMS.removeIf(n -> (n.getEmail().equalsIgnoreCase(email)) && n.getId() == id);
        itemRepository.updateFile(ALL_ITEMS);
    }

    public void changeCount(String email, int id, int newCount) {
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email) && item.getId() == id) {
                item.setCount(newCount);
            }
        }
        itemRepository.updateFile(ALL_ITEMS);
    }

    public void deleteCart(String email) {
        ALL_ITEMS.removeIf(item -> item.getEmail().equalsIgnoreCase(email));
        itemRepository.updateFile(ALL_ITEMS);
    }


}
