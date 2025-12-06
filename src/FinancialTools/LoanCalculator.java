package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class LoanCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Loan Calculator ---");

        double loanAmount = InputHelper.readDouble(scanner, "Enter the loan amount: ");
        double annualRate = InputHelper.readDouble(scanner, "Enter the annual interest rate (%): ");
        int years = InputHelper.readInt(scanner, "Enter the loan term in years: ");

        double monthlyRate = annualRate / 100 / 12;
        int totalMonths = years * 12;

        double monthlyPayment = loanAmount * (monthlyRate * Math.pow(1 + monthlyRate, totalMonths)) /
                (Math.pow(1 + monthlyRate, totalMonths) - 1);

        double totalPaid = monthlyPayment * totalMonths;
        double totalInterest = totalPaid - loanAmount;

        System.out.println(String.format("\nLoan Summary for %.2f over %d years at %.2f%% annual interest:", loanAmount, years, annualRate));
        System.out.println(String.format("Monthly Payment: %.2f", monthlyPayment));
        System.out.println(String.format("Total Amount to be Paid: %.2f", totalPaid));
        System.out.println(String.format("Total Interest Paid: %.2f", totalInterest));

}
}
