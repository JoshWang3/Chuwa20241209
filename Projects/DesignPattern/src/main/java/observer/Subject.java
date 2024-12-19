package observer;

public interface Subject {

    // add observer
    void attach(Observer observer);

    // delete
    void detach(Observer observer);

    // notify
    void notify(String message);
}
