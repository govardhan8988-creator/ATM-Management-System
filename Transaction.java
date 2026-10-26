import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Transaction {

    private String type;
    private double amount;
    private LocalDateTime dateTime;

    private static final String FILE_NAME = "transactions.txt";

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public Transaction(String type, double amount, LocalDateTime dateTime) {
        this.type = type;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public void display() {
        System.out.println(type + " : Rs." + amount);
        System.out.println("Date/Time : " + dateTime.format(FORMATTER));
    }

    public void saveToFile() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(
                type + "," +
                amount + "," +
                dateTime.format(FORMATTER) +
                "\n"
            );
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving transaction.");
        }
    }

    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return transactions;
            }
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] data = line.split(",", 3);
                if (data.length == 3) {
                    String type = data[0];
                    double amount = Double.parseDouble(data[1]);
                    LocalDateTime dateTime =
                            LocalDateTime.parse(data[2], FORMATTER);
                    transactions.add(
                            new Transaction(type, amount, dateTime)
                    );
                }
            }
            fileScanner.close();
        } 
        catch (Exception e) {
            System.out.println("Error loading transactions.");
        }
        return transactions;
    }
    
}