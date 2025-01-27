package composite;

import product.CosmeticProduct;

import java.util.ArrayList;
import java.util.List;

public class CosmeticCollection extends CosmeticProduct {

    private List<CosmeticProduct> items = new ArrayList<>();

    public void addItem(CosmeticProduct product) {
        items.add(product);
    }

    @Override
    public void apply() {
        System.out.println("Applying all products in the collection:");
        for (CosmeticProduct item : items) {
            item.apply();
        }
    }

}