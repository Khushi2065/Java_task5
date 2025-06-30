import java.util.Scanner;
import java.util.HashMap;

public class BankSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Account> accounts = new HashMap<>(); 

        System.out.println("Welcome to the Bank Account Simulator!");

        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Display Account Details");
            System.out.println("5. Display Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: Rs.");
                    double initialBalance = -1;
                    try {
                        initialBalance = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount. Please enter a number.");
                        break;
                    }
                    if (initialBalance < 0) {
                        System.out.println("Initial balance cannot be negative.");
                        break;
                    }
                    Account newAccount = new Account(name, initialBalance);
                    accounts.put(newAccount.getAccountNumber(), newAccount);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String depAccountNumber = scanner.nextLine();
                    Account depAccount = accounts.get(depAccountNumber);
                    if (depAccount != null) {
                        System.out.print("Enter amount to deposit: Rs.");
                        double depAmount = -1;
                        try {
                            depAmount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Please enter a number.");
                            break;
                        }
                        depAccount.deposit(depAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String withAccountNumber = scanner.nextLine();
                    Account withAccount = accounts.get(withAccountNumber);
                    if (withAccount != null) {
                        System.out.print("Enter amount to withdraw: Rs.");
                        double withAmount = -1;
                        try {
                            withAmount = Double.parseDouble(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Please enter a number.");
                            break;
                        }
                        withAccount.withdraw(withAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String detailsAccountNumber = scanner.nextLine();
                    Account detailsAccount = accounts.get(detailsAccountNumber);
                    if (detailsAccount != null) {
                        detailsAccount.displayAccountDetails();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String historyAccountNumber = scanner.nextLine();
                    Account historyAccount = accounts.get(historyAccountNumber);
                    if (historyAccount != null) {
                        historyAccount.displayTransactionHistory();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Account Simulator. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}