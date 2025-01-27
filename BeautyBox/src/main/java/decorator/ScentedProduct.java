package decorator;

import product.CosmeticProduct;

public class ScentedProduct extends CosmeticProduct {

    private CosmeticProduct product;

    public ScentedProduct(CosmeticProduct product) {
        this.product = product;
    }

    @Override
    public void apply() {
        product.apply();
        System.out.println("Product has a pleasant scent.");
    }
}