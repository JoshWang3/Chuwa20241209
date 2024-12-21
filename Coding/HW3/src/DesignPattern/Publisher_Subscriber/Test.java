package DesignPattern.Publisher_Subscriber;

public class Test {
    public static void main(String[] args) {
        NewsAgency newsAgency = new NewsAgency();

        Subscriber alice = new NewsSubscriber("Alice");
        Subscriber bob = new NewsSubscriber("Bob");

        newsAgency.subscribe(alice);
        newsAgency.subscribe(bob);

        newsAgency.notifySubscribers("Breaking News!");

        newsAgency.unsubscribe(bob);

        newsAgency.notifySubscribers("Update!");
    }
}
