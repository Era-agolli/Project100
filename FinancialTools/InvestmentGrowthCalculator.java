package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class InvestmentGrowthCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Investment Growth Calculator ---");

        double principal = InputHelper.readDouble(scanner, "Enter the initial investment amount: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the  annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the investment duration in years: ");
        int compoundsPerYear = InputHelper.readInt(scanner, "Enter the number of compounding periods per year: ");

        double rate = annualRate / 100;
        double amount = principal * Math.pow(1 + rate / compoundsPerYear, compoundsPerYear * years);
        double interestEarned = amount - principal;

        System.out.println(String.format("\nAfter %d years at an annual rate of %.2f%% (compounded %d times per year):", years, annualRate, compoundsPerYear));
        System.out.println(String.format("Final Investment Value: %.2f", amount));
        System.out.println(String.format("Total Interest Earned: %.2f", interestEarned));
    }
}

