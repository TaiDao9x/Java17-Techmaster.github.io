package backend.User.service;

import backend.User.model.Item;
import backend.User.repository.ItemRepository;

import java.util.ArrayList;

public class ItemService {
    ItemRepository itemRepository = new ItemRepository();
    ArrayList<Item> ALL_ITEMS = itemRepository.findAllItem();

    public void addItemFromIdBook(Item item) {
        ALL_ITEMS.add(item);
        itemRepository.updateFile(ALL_ITEMS);
    }
}
