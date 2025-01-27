package factory;

import product.CosmeticProduct;
import product.Lipstick;

public class LipstickFactory extends CosmeticFactory {

    @Override
    public CosmeticProduct createProduct() {
        return new Lipstick();
    }

}