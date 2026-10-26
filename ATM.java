import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private BankAccount account;
    private ArrayList<Transaction> transactions;
    private Scanner scanner;

    public ATM(BankAccount account) {
    this.account = account;
    this.transactions = Transaction.loadTransactions();
    this.scanner = new Scanner(System.in);
}

    public void start() {
        System.out.println("================================");
        System.out.println("       ATM MANAGEMENT SYSTEM");
        System.out.println("================================");
        System.out.print("Enter Account Number: ");
        String enteredAccount = scanner.nextLine();
        if (!enteredAccount.equals(account.getAccountNumber())) {
            System.out.println("Invalid account number.");
            return;
        }
        System.out.print("Enter PIN: ");
        int enteredPin = scanner.nextInt();
        if (!account.validatePin(enteredPin)) {
            System.out.println("Invalid PIN.");
            return;
        }
        System.out.println("\nLogin successful!");
        showMenu();
    }

    private void showMenu() {
        int choice;
        do {
            System.out.println("\n================================");
            System.out.println("           ATM MENU");
            System.out.println("================================");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Mini Statement");
            System.out.println("6. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    changePin();
                    break;
                case 5:
                    showMiniStatement();
                    break;
                case 6:
                    System.out.println("Thank you for using our ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);
    }

    private void checkBalance() {
        System.out.println(
                "Current Balance: Rs." + account.getBalance()
        );
    }

    private void depositMoney() {
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        double oldBalance = account.getBalance();
        account.deposit(amount);
        if (amount > 0) {
        Transaction transaction =
                new Transaction("Deposit", amount);
        transactions.add(transaction);
        transaction.saveToFile();
        }
    }

    private void withdrawMoney() {
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        boolean success = account.withdraw(amount);
        if (success) {
            Transaction transaction =
                    new Transaction("Withdrawal", amount);
            transactions.add(transaction);
            transaction.saveToFile();
        }
    }

    private void changePin() {
        System.out.print("Enter current PIN: ");
        int oldPin = scanner.nextInt();
        System.out.print("Enter new 4-digit PIN: ");
        int newPin = scanner.nextInt();
        boolean changed = account.changePin(oldPin, newPin);
        if (changed) {
            System.out.println("PIN changed successfully.");
        } else {
            System.out.println("PIN change failed.");
        }
    }

    private void showMiniStatement() {
        System.out.println("\n================================");
        System.out.println("         MINI STATEMENT");
        System.out.println("================================");
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("Total Transactions: " + transactions.size());
            System.out.println("--------------------------------");
            for (Transaction transaction : transactions) {
                transaction.display();
            }
        }
        System.out.println("--------------------------------");
        System.out.println(
                "Current Balance: Rs." + account.getBalance()
        );
        System.out.println("================================");
    }
    
}
