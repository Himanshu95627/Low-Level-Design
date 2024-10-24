package src.obsearvables;

import src.obsearvers.NotificationAlertObserver;

public interface StockObservable {
    void add(NotificationAlertObserver observer);

    void remove(NotificationAlertObserver observer);

    void notifySubscribers();

    int getStockCount();

    void setStockCount(int newStockCount);

}
