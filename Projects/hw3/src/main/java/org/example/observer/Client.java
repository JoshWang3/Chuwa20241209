package org.example.observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        WeiXinUser user1 = new WeiXinUser("user1");
        WeiXinUser user2 = new WeiXinUser("user2");
        WeiXinUser user3 = new WeiXinUser("user3");
        subscriptionSubject.attach(user1);
        subscriptionSubject.attach(user2);
        subscriptionSubject.attach(user3);
        subscriptionSubject.notify("message1");
        subscriptionSubject.detach(user2);
        subscriptionSubject.notify("message2");
    }
}
