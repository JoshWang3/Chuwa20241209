package observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        Observer user1 = new WeixinUser("SunWukong"); // Three observers (users)
        Observer user2 = new WeixinUser("Pig");
        Observer user3 = new WeixinUser("Monk");

        subject.attach(user1);
        subject.attach(user2);
        subject.attach(user3);

        subject.notify("The chanel is updated!");
    }
}

/* Output:
*
* SunWukong received message: The channel is updated!
* Pig received message: The channel is updated!
* Monk received message: The channel is updated!
* */

/*
The Observer Pattern is a behavioral design pattern used to create a one-to-many dependency between objects.
This means when one object (called the Subject) changes its state,
all its dependents (called Observers) are notified automatically and updated.

Loose Coupling: The subject and observers are loosely coupled.
The subject doesn't need to know the concrete class of the observer.

Real-World Examples:
    News subscription: Subscribe to a newsletter (subject), and when there’s new content, all subscribers (observers) get notified.
    UI Event Listeners: Buttons notify event listeners (observers) when clicked.

 Benefits:
    Promotes loose coupling between subject and observers.
    Supports dynamic subscription: observers can be added/removed at runtime.
    Makes code more flexible and scalable.
*/