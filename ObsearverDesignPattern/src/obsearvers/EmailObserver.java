package src.obsearvers;

import src.obsearvables.StockObservable;

public class EmailObserver implements NotificationAlertObserver {
    private final StockObservable observable;
    private final String emailId;

    public EmailObserver(StockObservable observable, String emailId) {
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        System.out.println("Email Notification for emailId " + emailId);
    }
}
