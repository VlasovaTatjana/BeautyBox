public class LipstickFactory extends CosmeticFactory {

    @Override
    CosmeticProduct createProduct() {
        return new Lipstick();
    }

}