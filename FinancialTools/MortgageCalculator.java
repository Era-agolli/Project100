package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class MortgageCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Mortgage Calculator ---");

        double housePrice = InputHelper.readDouble(scanner, "Enter the house price: ");
        double downPayment = InputHelper.readDouble(scanner, "Enter the down payment: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the mortgage term in years: ");

        double loanAmount = housePrice - downPayment;
        double monthlyRate = annualRate / 100 / 12;
        int totalMonths = years * 12;

        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, totalMonths)) /
                (Math.pow(1 + monthlyRate, totalMonths) - 1);

        double totalPaid = monthlyPayment * totalMonths;
        double totalInterest = totalPaid - loanAmount;

        System.out.println(String.format("\nMortgage Summary for a house priced at %.2f with a down payment of %.2f:", housePrice, downPayment));
        System.out.println(String.format("Loan Amount: %.2f", loanAmount));
        System.out.println(String.format("Monthly Payment: %.2f", monthlyPayment));
        System.out.println(String.format("Total Amount to be Paid: %.2f", totalPaid));
        System.out.println(String.format("Total Interest Paid: %.2f", totalInterest));
    }
}
