package src.obsearvers;

import src.obsearvables.StockObservable;

public class MobileObserver implements NotificationAlertObserver {
    private final StockObservable observable;
    private final String userName;

    public MobileObserver(StockObservable observable, String userName) {
        this.observable = observable;
        this.userName = userName;
    }

    @Override
    public void update() {
        System.out.println("Mobile notification for user : " + userName);
    }
}
