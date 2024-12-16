package Chuwa20241209.Coding.HW2.hw20.Encapsulation;

class Account {
    // Private fields (data hiding)
    private String accountNumber;
    private double balance;

    // Constructor to initialize account number and balance
    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter for accountNumber (read-only access)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance (read-only access)
    public double getBalance() {
        return balance;
    }

    // Method to deposit money (controlled access)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money (controlled access)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        // Create a BankAccount object
        Account account = new Account("123456789", 500.0);

        // Accessing number and balance via getter
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Balance: $" + account.getBalance());

        // Depositing money
        account.deposit(150.0);

        // Trying to withdraw more than the balance
        account.withdraw(700.0); // Output: Insufficient funds or invalid amount.

        // Withdrawing a valid amount
        account.withdraw(200.0); // Withdraws successfully

        // Display final balance
        System.out.println("Final Account Balance: $" + account.getBalance());
    }

}
