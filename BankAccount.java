import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BankAccount {

    private String accountNumber;
    private int pin;
    private double balance;

    private static final String FILE_NAME = "account.txt";

    public BankAccount(String accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public boolean validatePin(int enteredPin) {
        return pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            saveAccount();
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (amount > 10000) {
            System.out.println("Maximum withdrawal limit is Rs.10000.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }
        balance -= amount;
        saveAccount();
        System.out.println("Please collect your cash.");
        return true;
    }

    public boolean changePin(int oldPin, int newPin) {
        if (pin != oldPin) {
            System.out.println("Incorrect current PIN.");
            return false;
        }
        if (newPin < 1000 || newPin > 9999) {
            System.out.println("New PIN must contain exactly 4 digits.");
            return false;
        }
        if (newPin == oldPin) {
            System.out.println("New PIN must be different from old PIN.");
            return false;
        }
        pin = newPin;
        saveAccount();
        return true;
    }

    // Save account information into account.txt
    private void saveAccount() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(accountNumber + "\n");
            writer.write(pin + "\n");
            writer.write(balance + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving account data.");
        }
    }

    // Load account information from account.txt
    public static BankAccount loadAccount() {
        try {
            File file = new File(FILE_NAME);
            Scanner fileScanner = new Scanner(file);
            String accountNumber = fileScanner.nextLine();
            int pin = Integer.parseInt(fileScanner.nextLine());
            double balance = Double.parseDouble(fileScanner.nextLine());
            fileScanner.close();
            return new BankAccount(
                    accountNumber,
                    pin,
                    balance
            );
        } catch (Exception e) {
            System.out.println("Could not load account data.");
            return null;
        }
    }
    
}