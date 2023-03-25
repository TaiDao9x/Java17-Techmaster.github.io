package homework_FPTshop.backend.repository;

import homework_FPTshop.backend.database.FPTShopDatabase;
import homework_FPTshop.backend.model.Product;

import java.util.ArrayList;

public class FPTShopRepository {
    public ArrayList<Product> findAll() {
        return (ArrayList<Product>) FPTShopDatabase.list;
    }
}
