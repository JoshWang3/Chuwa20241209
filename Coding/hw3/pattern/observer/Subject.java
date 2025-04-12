package observer;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notify(String message); // NotifyObservers
}

// SubscriptionSubject is the subject. It manages a list of Observers.