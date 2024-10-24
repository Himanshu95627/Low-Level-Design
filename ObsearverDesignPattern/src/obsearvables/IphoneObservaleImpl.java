package src.obsearvables;

import src.obsearvers.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservaleImpl implements StockObservable {
    private final List<NotificationAlertObserver> observers = new ArrayList<>();
    private int stockCount = 0;


    @Override
    public void add(NotificationAlertObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void setStockCount(int newStockCount) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount += newStockCount;
    }
}
