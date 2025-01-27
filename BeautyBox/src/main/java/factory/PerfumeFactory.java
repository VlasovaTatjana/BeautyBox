package factory;

import product.CosmeticProduct;
import product.Perfume;

public class PerfumeFactory extends CosmeticFactory {

    @Override
    public CosmeticProduct createProduct() {
        return new Perfume();
    }

}