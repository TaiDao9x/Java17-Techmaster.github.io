package backend.User.service;

import backend.User.model.Item;
import backend.User.repository.ItemRepository;
import backend.User.ultils.ItemFileUltils;

import java.util.ArrayList;

public class ItemService {
    ItemRepository itemRepository = new ItemRepository();
    ArrayList<Item> ALL_ITEMS = itemRepository.findAllItem();

    public void addItemFromIdBook(Item item) {
        ALL_ITEMS.add(item);
        itemRepository.updateFile(ALL_ITEMS);
    }

    public ArrayList<Item> getCart(String email) {
        ArrayList<Item> items = new ArrayList<>();
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email)) {
                items.add(item);
            }
        }
        return items;
    }

    public int getTotal(String email) {
        int rs = 0;
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email)) {
                rs += (item.getCount() * item.getPrice());
            }
        }
        return rs;
    }

    public void deleteItemFromCart(int id, String email) {
        ArrayList<Item> toRemove = new ArrayList<>();
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email) && item.getId() == id) {
                toRemove.add(item);
            }
        }
        ALL_ITEMS.removeAll(toRemove);
        ItemFileUltils.setDataToFile("item.json", ALL_ITEMS);
    }

    public boolean checkItemExist(int id, String email) {
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email) && item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeCount(int id, String email, int count) {
        for (Item item : ALL_ITEMS) {
            if (item.getEmail().equalsIgnoreCase(email) && item.getId() == id) {
                item.setCount(count);
            }
        }
        ItemFileUltils.setDataToFile("item.json", ALL_ITEMS);
    }
}
