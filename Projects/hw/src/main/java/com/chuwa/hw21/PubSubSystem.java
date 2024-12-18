package com.chuwa.hw21;

import java.util.*;

public class PubSubSystem {
    private final Map<String, List<Subscriber>> topicSubscribers = new HashMap<>();

    public void publish(String topic, String message) {
        System.out.println("Publisher publishing message to topic '" + topic + "': " + message);
        List<Subscriber> subscribers = topicSubscribers.getOrDefault(topic, new ArrayList<>());
        for (Subscriber subscriber : subscribers) {
            subscriber.receive(topic, message);
        }
    }

    public void subscribe(String topic, Subscriber subscriber) {
        topicSubscribers.putIfAbsent(topic, new ArrayList<>());
        topicSubscribers.get(topic).add(subscriber);
        System.out.println(subscriber.getName() + " subscribed to topic: " + topic);
    }

    public void unsubscribe(String topic, Subscriber subscriber) {
        if (topicSubscribers.containsKey(topic)) {
            topicSubscribers.get(topic).remove(subscriber);
            System.out.println(subscriber.getName() + " unsubscribed from topic: " + topic);
        }
    }

    interface Subscriber {
        void receive(String topic, String message);

        String getName();
    }

    public static void main(String[] args) {
        PubSubSystem pubSubSystem = new PubSubSystem();

        Subscriber alice = new Subscriber() {
            private final String name = "Alice";

            @Override
            public void receive(String topic, String message) {
                System.out.println(name + " received message on topic '" + topic + "': " + message);
            }

            @Override
            public String getName() {
                return name;
            }
        };

        Subscriber bob = new Subscriber() {
            private final String name = "Bob";

            @Override
            public void receive(String topic, String message) {
                System.out.println(name + " received message on topic '" + topic + "': " + message);
            }

            @Override
            public String getName() {
                return name;
            }
        };

        pubSubSystem.subscribe("Sports", alice);
        pubSubSystem.subscribe("Sports", bob);
        pubSubSystem.subscribe("Tech", alice);

        pubSubSystem.publish("Sports", "The game starts at 7 PM!");
        pubSubSystem.publish("Tech", "New Java version released!");
    }
}
