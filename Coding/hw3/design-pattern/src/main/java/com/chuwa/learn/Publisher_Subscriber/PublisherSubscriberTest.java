package com.chuwa.learn.Publisher_Subscriber;

// Usage
public class PublisherSubscriberTest {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        Subscriber subscriber1 = new ConcreteSubscriber("Subscriber 1");
        Subscriber subscriber2 = new ConcreteSubscriber("Subscriber 2");

        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        publisher.publish("Design Patterns are fun!");
        publisher.unsubscribe(subscriber1);
        publisher.publish("Singleton is easy to understand!");
    }
}
