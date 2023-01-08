package backend.controler;

import backend.model.Item;
import backend.service.ItemService;

public class ItemControler {
    private final ItemService itemService = new ItemService();

    public void addItem(Item item) {
        itemService.addItem(item);
    }
}
