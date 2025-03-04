package PubSub;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject {
    private List<Observer> weixinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weixinUserList.add(observer);
        System.out.println("Observer added: " + observer);
    }

    @Override
    public void detach(Observer observer) {
        weixinUserList.remove(observer);
        System.out.println("Observer removed: " + observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}

