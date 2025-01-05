import java.util.ArrayList;
import java.util.Scanner;

public class ATMSimulation {
    // account details

    private double accountBalance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // Constructor to initialize account details

    public ATMSimulation(String initialPin, double initialBalance) {
        this.pin = initialPin;
        this.accountBalance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    // method used for balance inquiry

    public void checkBalance() {
        System.out.println("Your current account balance is: " + accountBalance);
        transactionHistory.add("Balance inquiry: " + accountBalance);
    }

    // method used for cash withdrawal

    public void withdrawCash(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > accountBalance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            accountBalance -= amount;
            System.out.println("Successfully Withdraw  " + amount);
            transactionHistory.add("Withdrawal: " + amount);
        }
    }

    // method used for cash deposit

    public void depositCash(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
        } else {
            accountBalance += amount;
            System.out.println("Successfully deposited " + amount);
            transactionHistory.add("Deposit: " + amount);
        }
    }

    //   change PIN

    public void changePIN(String oldPin, String newPin) {
        if (!oldPin.equals(pin)) {
            System.out.println("Incorrect old PIN. PIN change failed.");
        } else if (newPin.length() != 4 || !newPin.matches("\\d{4}")) {
            System.out.println("New PIN must be a 4-digit number.");
        } else {
            pin = newPin;
            System.out.println("PIN successfully changed.");
            transactionHistory.add("PIN changed.");
        }
    }

    //  display transaction history

    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Main method for user interaction

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ATMSimulation atm = new ATMSimulation("1234", 3000.0);

        System.out.println("Welcome to the ATM Machine Simulation!");
        
        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Cash Withdrawal");
            System.out.println("3. Cash Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawCash(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    atm.depositCash(depositAmount);
                    break;
                case 4:
                    System.out.println("Enter old PIN:");
                    String oldPin = scanner.next();
                    System.out.println("Enter new PIN:");
                    String newPin = scanner.next();
                    atm.changePIN(oldPin, newPin);
                    break;
                case 5:
                    atm.showTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
