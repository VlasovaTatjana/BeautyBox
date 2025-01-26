public class ScentedProduct extends CosmeticProduct {

    private CosmeticProduct product;

    public ScentedProduct(CosmeticProduct product) {
        this.product = product;
    }

    @Override
    void apply() {
        product.apply();
        System.out.println("Product has a pleasant scent.");
    }
}