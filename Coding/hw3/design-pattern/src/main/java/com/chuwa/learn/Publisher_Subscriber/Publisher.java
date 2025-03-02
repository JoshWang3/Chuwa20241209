package com.chuwa.learn.Publisher_Subscriber;

import java.util.ArrayList;
import java.util.List;

// Subject (Publisher)
class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String message;

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(message);
        }
    }

    public void publish(String message) {
        this.message = message;
        System.out.println("Publisher published: " + message);
        notifySubscribers();
    }
}
