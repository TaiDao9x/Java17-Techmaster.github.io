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
}
