package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class BankInterestProjection {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Interest Projection ---");
            System.out.println("1.Project Compound Interest for a Lump-Sum Investment. ");
            System.out.println("2.Project Savings with Recurring Monthly Deposits.");
            System.out.println("3.Year-by-year Combined Projection. ");
            System.out.println("0.Exit.");
            int choice = InputHelper.readInt(scanner,"Choose your option: ");

            switch (choice) {
                case 1 -> lumpSumProjection(scanner);
                case 2 -> recurringDepositProjection(scanner);
                case 3 -> combinedYearlyProjection(scanner);
                case 0 -> {
                    System.out.println("Exiting Bank Interest Projection...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    private void lumpSumProjection(Scanner scanner){
        System.out.println("\n--- Project Compound Interest for a Lump-Sum Investment ---");
        double principal = InputHelper.readDouble(scanner,"Enter the initial investment amount: ");
        double annualRate = InputHelper.readDouble(scanner,"Enter the annual interest rate (%): ");
        int years = InputHelper.readInt(scanner,"Enter the investment duration in years: ");
        int compPerYear = InputHelper.readInt(scanner,"Enter the number of times interest is compounded per year: ");

        double amount = compoundAmount(principal,annualRate / 100.0 , years,compPerYear);
        double interestEarned = amount - principal;

        System.out.println();
        System.out.println(String.format("After %d years at an annual rate of %.4f%% (compounded %d times per years): " , years,annualRate,compPerYear));
        System.out.println("Final account balance: $ " + String.format("%.2f",amount));
        System.out.println("Total interest earned: $" + String.format("%.2f",interestEarned));
        System.out.println();
    }

    private void recurringDepositProjection(Scanner scanner){
        System.out.println("\n--- Project Savings with Recurring Monthly Deposits ---");
        double monthlyDeposit = InputHelper.readDouble(scanner, "Enter the monthly deposit amount: ");
        double initialBalance = InputHelper.readDouble(scanner, "Enter the initial balance (enter 0 if none): ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the  number of years for the projection: ");
        int compPerYear = InputHelper.readInt(scanner, "Enter the number of times interest is compounded per year : ");

        double finalBalance = futureValueWithMonthlyDeposits(initialBalance, monthlyDeposit, annualRate / 100.0, years, compPerYear);
        double totalDeposited = initialBalance + monthlyDeposit * 12 * years;
        double interestEarned = finalBalance - totalDeposited;

        System.out.println();
        System.out.println(String.format("After %d years with a monthly deposit %.2f at an annual interest rate of %.4f%%:", years, monthlyDeposit, annualRate));
        System.out.println("Total amount deposited: $ " + String.format("%.2f", totalDeposited));
        System.out.println("Final account balance: $ " + String.format("%.2f", finalBalance));
        System.out.println("Total interest earned: $ " + String.format("%.2f", interestEarned));
        System.out.println();
    }

    private void combinedYearlyProjection(Scanner scanner) {
        System.out.println("\n--- Year-by-year Combined Projection ---");

        double principal = InputHelper.readDouble(scanner, "Enter the initial principal (starting balance): ");
        double monthlyDeposit = InputHelper.readDouble(scanner, "Enter the monthly deposit amount: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the  annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the number of years to project: ");
        int compPerYear = InputHelper.readInt(scanner, "Enter the number of times interest is compounded per year: ");

        double balance = principal;
        double r = annualRate / 100.0;
        double periodicRate = r / compPerYear;

        System.out.println();
        System.out.printf("%-6s %-15s %-15s %-15s%n", "Year", "Start Balance", "Deposited This Year ", "Ending Balance");

        for (int y = 1; y <= years; y++) {
            double startBalance = balance;
            double depositedThisYear = monthlyDeposit * 12;

            if (compPerYear == 12) {
                for (int m = 0; m < 12; m++) {
                    balance += monthlyDeposit;
                    balance *= (1 + periodicRate);}
            } else {
                balance += depositedThisYear;
                int steps = compPerYear;
                for (int step = 0; step < steps; step++) {
                    balance *= (1 + periodicRate);
                }
            }
            System.out.printf("%-6d %-15.2f %-15.2f %-15.2f%n", y, startBalance, depositedThisYear, balance);}

        System.out.println();
        System.out.println("Projection complete.");
        System.out.println();
    }

    private double compoundAmount(double principal, double annualRateDecimal, int years, int compPerYear) {
        if (compPerYear <= 0) compPerYear = 1;
        double base = 1 + annualRateDecimal / compPerYear;
        return principal * Math.pow(base, compPerYear * years);
    }

    private double futureValueWithMonthlyDeposits(double initialBalance, double monthlyDeposit, double annualRateDecimal, int years, int compPerYear) {
        if (compPerYear <= 0) compPerYear = 12;
        double balance = initialBalance;
        double periodicRate = annualRateDecimal / compPerYear;
        int totalPeriods = compPerYear * years;


        if (compPerYear == 12) {
            for (int i = 0; i < totalPeriods; i++) {
                balance += monthlyDeposit;
                balance *= (1 + periodicRate); }
            return balance;
        }

        double depositsPerPeriod = 12.0 / compPerYear * monthlyDeposit;
        for (int i = 0; i < totalPeriods; i++) {
            balance += depositsPerPeriod;
            balance *= (1 + periodicRate);
        }
        return balance;
    }
}



