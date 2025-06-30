import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private ArrayList<String> transactionHistory;
    private static int nextAccountNumber = 1001; // Starting account number

    public Account(String accountHolderName, double initialBalance) {
        this.accountNumber = String.valueOf(nextAccountNumber++);
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial balance: Rs." + String.format("%.2f", initialBalance));
        System.out.println("Account created successfully for " + accountHolderName + ". Account Number: " + this.accountNumber);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    private void addTransaction(String type, double amount, double newBalance) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        String transactionEntry = String.format("[%s] %s: Rs.%.2f. New Balance: Rs.%.2f", timestamp, type, amount, newBalance);
        transactionHistory.add(transactionEntry);
    }

     private void addTransaction(String message) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = sdf.format(new Date());
        String transactionEntry = String.format("[%s] %s", timestamp, message);
        transactionHistory.add(transactionEntry);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount, balance);
            System.out.println("Deposited Rs." + String.format("%.2f", amount) + " successfully. New balance: Rs." + String.format("%.2f", balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                addTransaction("Withdrawal", amount, balance);
                System.out.println("Withdrew Rs." + String.format("%.2f", amount) + " successfully. New balance: Rs." + String.format("%.2f", balance));
            } else {
                System.out.println("Insufficient funds. Current balance: Rs." + String.format("%.2f", balance));
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History for Account " + accountNumber + " (" + accountHolderName + ") ---");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        System.out.println("--------------------------------------------------");
    }

    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: Rs." + String.format("%.2f", balance));
        System.out.println("-----------------------");
    }
}