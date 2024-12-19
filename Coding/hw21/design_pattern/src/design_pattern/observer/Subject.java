package design_pattern.observer;

public interface Subject {
    void attach(Observer observer);

    void remove(Observer observer);

    void notify(String message);
}
