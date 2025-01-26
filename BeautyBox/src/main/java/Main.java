public class Main {

    public static void main(String[] args) {

        System.out.println("--- Factory Method ---");
        CosmeticFactory lipstickFactory = new LipstickFactory();
        CosmeticProduct lipstick = lipstickFactory.createProduct();
        lipstick.apply();
        System.out.println();

        System.out.println("--- Decorator ---");
        CosmeticProduct scentedLipstick = new ScentedProduct(lipstick);
        scentedLipstick.apply();
        System.out.println();

        System.out.println("--- Composite ---");
        CosmeticCollection collection = new CosmeticCollection();
        collection.addItem(lipstick);
        collection.addItem(new Perfume());
        System.out.println("Applying all products in the collection:");
        collection.apply();
        System.out.println();

        System.out.println("--- Observer ---");
        CosmeticStore store = new CosmeticStore();
        UserObserver userObserver = new UserObserver();
        store.addObserver(userObserver);
        store.addProduct(new Perfume());
        System.out.println();

        System.out.println("--- Strategy ---");
        ApplicationStrategy brushStrategy = new ApplyWithBrush();
        ApplicationStrategy fingerStrategy = new ApplyWithFingers();

        System.out.println("Using Application Strategies:");
        System.out.print("\t");
        brushStrategy.apply();
        System.out.print("\t");
        fingerStrategy.apply();
        System.out.println();
    }

}