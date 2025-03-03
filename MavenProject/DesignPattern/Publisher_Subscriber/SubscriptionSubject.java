package Chuwa20241209.MavenProject.DesignPattern.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject {
    private List<Observer> weiXinUserList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            observer.update(message);
        }
    }
}
