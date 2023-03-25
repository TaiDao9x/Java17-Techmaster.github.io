package homework_FPTshop.backend.controler;

import homework_FPTshop.backend.model.Product;
import homework_FPTshop.backend.service.FPTShopService;

import java.util.List;

public class FPTShopControler {
    public final FPTShopService fptShopService = new FPTShopService();

    public List<Product> findByCategory(String category) {
       return fptShopService.findByCategory(category);
    }

    public List<Product> printByBrand(String brand) {
        return fptShopService.printByBrand(brand);
    }
}
