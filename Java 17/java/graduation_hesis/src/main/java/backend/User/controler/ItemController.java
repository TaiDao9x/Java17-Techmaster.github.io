package backend.User.controler;

import backend.User.model.Item;
import backend.User.service.ItemService;

public class ItemController {
    ItemService itemService = new ItemService();
    public void addItemFromIdBook(Item item) {
        itemService.addItemFromIdBook(item);
    }
}
