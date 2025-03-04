public class SubscriptionSubject implements Subject {
    private List<Observer> weixinUserList = new ArrayList<>();
    public void attach(Observer observer) {
        weixinUserList.add(observer);
    }

    public void detach(Observer observer) {
        weixinUserList.remove(observer);
    }

    public notify(String message) {
        for (Observer observer : weixinUserList) {
            observer.update(message);
        }
    }
}