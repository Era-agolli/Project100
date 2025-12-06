package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class IdealWeightCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Ideal Weight Calculator ---\n");

        double heightCm = InputHelper.readDouble(scanner, "Enter your height in cm: ");
        char gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");

        while (gender != 'M' && gender != 'F') {
            System.out.println("Invalid input. Enter M or F.");
            gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        }

        double heightM = heightCm / 100.0;

        // BMI target range
        double minBMI = 18.5;
        double maxBMI = 24.9;

        double minWeight = minBMI * heightM * heightM;
        double maxWeight = maxBMI * heightM * heightM;

        System.out.printf("\nIdeal weight range: %.1f kg - %.1f kg\n\n", minWeight, maxWeight);
    }
}
