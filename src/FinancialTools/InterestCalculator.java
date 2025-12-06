package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class InterestCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interest Calculator ---");

        double principal = InputHelper.readDouble(scanner, "Enter the principal amount: ");
        double rate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the number of years: ");

        System.out.println("\nChoose interest type:");
        System.out.println("1. Simple Interest");
        System.out.println("2. Compound Interest");
        int type = InputHelper.readInt(scanner, "Enter your choice (1 or 2): ");

        switch (type) {
            case 1 -> calculateSimple(principal, rate, years);
            case 2 -> calculateCompound(principal, rate, years);
            default -> System.out.println("Invalid choice.Please select 1 or 2.");
        }
    }

    private void calculateSimple(double p, double r, int y) {
        double interest = p * (r / 100) * y;
        double total = p + interest;

        System.out.println(String.format("\nSimple Interest for %.2f over %d years at %.2f%%: %.2f", p, y, r, interest));
        System.out.println(String.format("Total Amount (Principal + Interest): %.2f", total));
    }

    private void calculateCompound(double p, double r, int y) {
        double amount = p * Math.pow(1 + (r / 100), y);
        double interest = amount - p;

        System.out.println(String.format("\nCompound Interest for %.2f over %d years at %.2f%%: %.2f", p, y, r, interest));
        System.out.println(String.format("Total Amount (Principal + Interest): %.2f", amount));
    }
}
