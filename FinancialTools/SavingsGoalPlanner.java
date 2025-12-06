package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class SavingsGoalPlanner {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Savings Goal Planner ---");

        double goalAmount = InputHelper.readDouble(scanner, "Enter your savings goal amount: ");
        double currentSavings = InputHelper.readDouble(scanner, "Enter the current savings: ");
        double monthlyContribution = InputHelper.readDouble(scanner, "Enter the monthly contribution: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");

        double monthlyRate = annualRate / 100 / 12;
        int months = 0;
        double balance = currentSavings;

        while (balance < goalAmount) {
            balance += monthlyContribution;
            balance += balance * monthlyRate;
            months++;

            if (months > 2000) {
                System.out.println("The goal is too high or the monthly contribution is too low. Unable to reach the goal.");
                return;
            }
        }

        double years = months / 12.0;

        System.out.println(String.format("\nCongratulations! You will reach your savings goal of %.2f in:", goalAmount));
        System.out.println(String.format("Time Required: %d months (%.2f years)", months, years));
        System.out.println(String.format("Projected Final Balance: %.2f", balance));
    }
}
