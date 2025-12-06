package FinancialTools;

import utils.InputHelper;

import java.util.Scanner;

public class CurrencyConverter {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Currency Converter ---");
        System.out.println("NOTE: Please enter the exchange rate manually.\n");
        System.out.println();

        String from = InputHelper.readString(scanner, "Enter the currency to convert from: ");
        String to = InputHelper.readString(scanner, "Enter the currency to convert to: ");
        double amount = InputHelper.readDouble(scanner, "Enter the amount to convert: ");
        double rate = InputHelper.readDouble(scanner, "Enter the  exchange rate (1 " + from + " = ? " + to + "): ");

        double converted = amount * rate;

        System.out.println(String.format("\n%.2f %s is equivalent to %.2f %s.", amount, from, converted, to));
    }
}

