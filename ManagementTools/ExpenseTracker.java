package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpenseTracker {

    static class Expense {
        String name;
        double amount;

        Expense(String name, double amount) {
            this.name = name;
            this.amount = amount;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();

        System.out.println("\n--- Expense Tracker ---");

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spent");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String name = InputHelper.readString(scanner, "Enter expense name: ");
                    double amount = InputHelper.readDouble(scanner, "Enter amount: ");
                    expenses.add(new Expense(name, amount));
                    System.out.println("Expense added.");
                }
                case 2 -> {
                    System.out.println("\n--- Expense List ---");
                    if (expenses.isEmpty()) System.out.println("No expenses recorded.");
                    else {
                        for (int i = 0; i < expenses.size(); i++)
                            System.out.println((i + 1) + ". " + expenses.get(i).name + " - $" + expenses.get(i).amount);
                    }
                }
                case 3 -> {
                    double total = 0;
                    for (Expense e : expenses) total += e.amount;
                    System.out.println("Total spent: $" + total);
                }
                case 4 -> {
                    System.out.println("Exiting Expense Tracker...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
