public class PerfumeFactory extends CosmeticFactory {

    @Override
    CosmeticProduct createProduct() {
        return new Perfume();
    }

}