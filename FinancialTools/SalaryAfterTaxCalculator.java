package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class SalaryAfterTaxCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Salary After Tax Calculator ---");

        double grossSalary = InputHelper.readDouble(scanner, "Enter your gross annual salary: ");
        double taxRate = InputHelper.readDouble(scanner, "Enter  the total tax rate (%): ");
        double deductions = InputHelper.readDouble(scanner, "Enter the  yearly deductions (0 if none): ");

        double taxableIncome = grossSalary - deductions;

        if (taxableIncome < 0) {
            taxableIncome = 0;
        }

        double taxAmount = taxableIncome * (taxRate / 100);
        double netSalary = grossSalary - taxAmount;

        System.out.println(String.format("\nSalary Breakdown for a gross annual salary of %.2f:", grossSalary));
        System.out.println(String.format("Taxable Income: %.2f", taxableIncome));
        System.out.println(String.format("Tax Amount: %.2f", taxAmount));
        System.out.println(String.format("Net Salary (after tax): %.2f", netSalary));
}}

