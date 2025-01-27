package observer;

import product.CosmeticProduct;

import java.util.ArrayList;
import java.util.List;

public class CosmeticStore {
    private List<CosmeticObserver> observers = new ArrayList<>();

    public void addObserver(CosmeticObserver observer) {
        observers.add(observer);
    }

    void notifyObservers(String event) {
        for (CosmeticObserver observer : observers) {
            observer.update(event);
        }
    }

    public void addProduct(CosmeticProduct product) {
        System.out.println("New product added to the store.");
        notifyObservers("A new cosmetic product is now available!");
    }

}