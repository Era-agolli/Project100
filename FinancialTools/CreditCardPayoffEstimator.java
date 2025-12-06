package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class CreditCardPayoffEstimator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Credit Card Payoff Estimator ---");

        double balance = InputHelper.readDouble(scanner, "Enter the outstanding balance: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");
        double monthlyPayment = InputHelper.readDouble(scanner, "Enter the fixed monthly payment: ");

        if (monthlyPayment <= 0) {
            System.out.println("Error: Monthly payment must be greater than 0.");
            return;
        }

        double monthlyRate = annualRate / 100 / 12;
        int months = 0;
        double currentBalance = balance;

        while (currentBalance > 0) {
            double interest = currentBalance * monthlyRate;
            currentBalance += interest;
            currentBalance -= monthlyPayment;

            months++;

            if (months > 1000) {
                System.out.println("\nWarning: The Monthly payment is too low. The debt will never be fully paid off.");
                return;
            }
        }

        System.out.println("\nPayoff Summary:");
        System.out.println("Time needed to pay off debt: " + months + " months");
        System.out.println("Total amount paid: $ " + String.format("%.2f", months * monthlyPayment));
        System.out.println("Total interest paid: $ " + String.format("%.2f", months * monthlyPayment - balance));
    }
}
