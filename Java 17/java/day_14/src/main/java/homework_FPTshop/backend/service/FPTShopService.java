package homework_FPTshop.backend.service;

import homework_FPTshop.backend.model.Product;
import homework_FPTshop.backend.repository.FPTShopRepository;

import java.util.ArrayList;
import java.util.List;

public class FPTShopService {
    public final FPTShopRepository fptShopRepository = new FPTShopRepository();
    public final ArrayList<Product> ALL_PRODUCT = fptShopRepository.findAll();

    public List<Product> findByCategory(String category) {
        ArrayList<Product> findByCategory = new ArrayList<>();
        for (Product p : ALL_PRODUCT) {
            if (p.getCategory().contains(category)) {
                findByCategory.add(p);
            }
        }
        return findByCategory;
    }

    public List<Product> printByBrand(String brand) {

    }
}
