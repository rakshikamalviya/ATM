package ATMSystem;

public class ATM {
    private int balance = 5000; 
    private final int correctPin = 1234; 

    public boolean verifyPin(int pin) {
        return pin == correctPin;
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void withdrawCash(int amount) {
        if (amount < 100) {
            System.out.println("Minimum withdrawal amount is ₹100");
        } else if (amount > 10000) {
            System.out.println("Maximum withdrawal per transaction is ₹10,000");
        } else if (amount % 100 != 0) {
            System.out.println("Amount must be in multiples of ₹100");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal Successful! Please take ₹" + amount);
            System.out.println("Remaining Balance: ₹" + balance);
        }
    }

    public void depositMoney(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount!");
        } else {
            balance += amount;
            System.out.println("Successfully Deposited ₹" + amount);
            System.out.println("Updated Balance: ₹" + balance);
        }
    }
}
