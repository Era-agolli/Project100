package ManagementTools;

import utils.InputHelper;

import java.util.Scanner;

public class SimpleBankAccount {

    private double balance = 0;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Simple Bank Account ---");

        while (true) {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.println("Choose an option:");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    double amount = InputHelper.readDouble(scanner, "Enter deposit amount: ");
                    balance += amount;
                    System.out.println("Deposited: $" + amount);
                }
                case 2 -> {
                    double amount = InputHelper.readDouble(scanner, "Enter withdrawal amount: ");
                    if (amount > balance) {
                        System.out.println("Insufficient funds.");
                    } else {
                        balance -= amount;
                        System.out.println("Withdrawn: $" + amount);
                    }
                }
                case 3 -> System.out.println("Current Balance: $" + balance);
                case 4 -> {
                    System.out.println("Closing bank account...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
