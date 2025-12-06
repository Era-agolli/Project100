package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class BillSplitter {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Bill Splitter ---");

        double total = InputHelper.readDouble(scanner, "Enter the total bill amount: ");
        int people = InputHelper.readInt(scanner, "Enter the number of people: ");
        double tipPercent = InputHelper.readDouble(scanner, "Enter the tip percentage: ");

        if (people <= 0) {
            System.out.println("Error: number of people must be greater than zero.");
            return;
        }

        double tipAmount = total * (tipPercent / 100);
        double totalWithTip = total + tipAmount;
        double splitAmount = totalWithTip / people;

        System.out.println("Tip amount: " + String.format("%.2f", tipAmount));
        System.out.println("Total amount (including tip): " + String.format("%.2f", totalWithTip));
        System.out.println("Each person should pay: " + String.format("%.2f", splitAmount));
    }

}
