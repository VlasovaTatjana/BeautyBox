public class UserObserver implements CosmeticObserver {

    @Override
    public void update(String event) {
        System.out.println("Notification: " + event);
    }

}