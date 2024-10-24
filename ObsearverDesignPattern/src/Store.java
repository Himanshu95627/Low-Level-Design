package src;

import src.obsearvables.IphoneObservaleImpl;
import src.obsearvables.StockObservable;
import src.obsearvers.EmailObserver;
import src.obsearvers.MobileObserver;
import src.obsearvers.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneObservale = new IphoneObservaleImpl();

        NotificationAlertObserver observer1 = new EmailObserver(iphoneObservale, "abc@gmail.com");
        NotificationAlertObserver observer2 = new MobileObserver(iphoneObservale, "Himanshu");
        NotificationAlertObserver observer3 = new EmailObserver(iphoneObservale, "pandey@111");

        iphoneObservale.add(observer1);
        iphoneObservale.add(observer2);
        iphoneObservale.add(observer3);


        iphoneObservale.setStockCount(10);
    }
}
