// PaymentStrategy interface for different payment methods
interface PaymentStrategy {
    void pay(double amount);
}

class CashPayment implements PaymentStrategy {

    public void pay(double amount) {
        // Implementation for cash payment
    }
}

class CardPayment implements PaymentStrategy {

    public void pay(double amount) {
        // Implementation for card payment
    }
}

// CentralPaymentSystem to handle payments
class CentralPaymentSystem {
    private static CentralPaymentSystem instance;

    private CentralPaymentSystem() {
        // Private constructor to prevent instantiation
    }

    public static CentralPaymentSystem getInstance() {
        if (instance == null) {
            instance = new CentralPaymentSystem();
        }
        return instance;
    }

    // Methods for payment processing
    public void processPayment(PaymentStrategy paymentStrategy, double amount) {
        paymentStrategy.pay(amount);
    }
}