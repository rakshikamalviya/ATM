package ATMSystem;
import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) throws InterruptedException  {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        int attempts = 0;
        int pin = 0;
        boolean pinVerified = false;

        while (attempts < 3) {
            System.out.print("Enter PIN (4 or 6 digits): ");
            String enteredPin = sc.next();

            if (!enteredPin.matches("\\d{4}|\\d{6}")) {
                System.out.println("Invalid PIN! Please enter a 4-digit or 6-digit numeric PIN.");
                attempts++;
                Thread.sleep(2000);
                continue; 
            }

            pin = Integer.parseInt(enteredPin);

            if (atm.verifyPin(pin)) {
                pinVerified = true;
                break; 
            } else {
                System.out.println("Incorrect PIN! Try again.");
                attempts++;
            }
        }

        if (!pinVerified) {
            System.out.println(" Too many incorrect attempts. Access Denied!");
            return; // 
        }

        System.out.println("PIN Verified Successfully!");

        while (true) {
            System.out.println("\n---- ATM MENU ----");
            System.out.println("1️. Check Balance");
            System.out.println("2️. Withdraw Cash");
            System.out.println("3️. Deposit Money");
            System.out.println("4️. Exit");
            System.out.print("Select an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    int withdrawAmount = sc.nextInt();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter deposit amount: ");
                    int depositAmount = sc.nextInt();
                    atm.depositMoney(depositAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Error in sleep: " + e.getMessage());
            }
        }
    }
}
