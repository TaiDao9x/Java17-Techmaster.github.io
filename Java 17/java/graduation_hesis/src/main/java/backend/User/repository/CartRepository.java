package backend.User.repository;

import backend.User.database.CartDatabase;
import backend.User.model.Cart;


public class CartRepository {
    public Cart cart() {
        return CartDatabase.cart();
    }

}
