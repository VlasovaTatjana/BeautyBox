import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeautyBoxTests {

    @Test
    void factoryMethodForLipstickTest() {
        CosmeticFactory lipstickFactory = new LipstickFactory();
        CosmeticProduct lipstick = lipstickFactory.createProduct();

        assertTrue(lipstick instanceof Lipstick);
        assertEquals("Applying lipstick.", getOutput(() -> lipstick.apply()));
    }

    @Test
    void factoryMethodForPerfumeTest() {
        CosmeticFactory perfumeFactory = new PerfumeFactory();
        CosmeticProduct perfume = perfumeFactory.createProduct();

        assertTrue(perfume instanceof Perfume);
        assertEquals("Spraying perfume.", getOutput(() -> perfume.apply()));
    }

    @Test
    void decoratorForScentedLipstickTest() {
        CosmeticProduct lipstick = new Lipstick();
        CosmeticProduct scentedLipstick = new ScentedProduct(lipstick);

        assertEquals("Applying lipstick.Product has a pleasant scent.", getOutput(() -> scentedLipstick.apply()));
    }

    @Test
    void compositeForCosmeticCollectionTest() {
        CosmeticCollection collection = new CosmeticCollection();
        collection.addItem(new Lipstick());
        collection.addItem(new Perfume());

        assertEquals("Applying all products in the collection:Applying lipstick.Spraying perfume.",
                getOutput(() -> collection.apply()));
    }

    @Test
    void observerForNewProductTest() {
        CosmeticStore store = new CosmeticStore();
        UserObserver userObserver = new UserObserver();
        store.addObserver(userObserver);

        String output = getOutput(() -> store.addProduct(new Perfume()));
        assertEquals("New product added to the store.Notification: A new cosmetic product is now available!", output);
    }

    @Test
    void strategyForApplicationMethodsTest() {
        ApplicationStrategy brushStrategy = new ApplyWithBrush();
        ApplicationStrategy fingerStrategy = new ApplyWithFingers();

        assertEquals("Applying product with a brush.", getOutput(() -> brushStrategy.apply()));
        assertEquals("Applying product with fingers.", getOutput(() -> fingerStrategy.apply()));
    }

    private String getOutput(Runnable action) {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            action.run();
        } finally {
            System.setOut(originalOut);
        }

        return output.toString().replaceAll("\\R", "");
    }

}