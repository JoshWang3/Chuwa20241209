package DesignPattern.Publisher_Subscriber;

public interface Subscriber {
    void update(String message);
    String getName();
}
