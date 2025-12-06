package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class BodyFatPercentageEstimator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Body Fat Percentage Estimator ---\n");

        // Input gender
        char gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        while (gender != 'M' && gender != 'F') {
            System.out.println("Invalid input. Enter M for male or F for female.");
            gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        }

        // Input measurements
        double height = InputHelper.readDouble(scanner, "Enter your height in cm: ");
        double neck = InputHelper.readDouble(scanner, "Enter your neck circumference in cm: ");
        double waist = InputHelper.readDouble(scanner, "Enter your waist circumference in cm: ");
        double hip = 0;

        if (gender == 'F') {
            hip = InputHelper.readDouble(scanner, "Enter your hip circumference in cm: ");
        }

        // Calculate body fat percentage
        double bodyFat;
        if (gender == 'M') {
            bodyFat = 495 / (1.0324 - 0.19077 * Math.log10(waist - neck) + 0.15456 * Math.log10(height)) - 450;
        } else {
            bodyFat = 495 / (1.29579 - 0.35004 * Math.log10(waist + hip - neck) + 0.22100 * Math.log10(height)) - 450;
        }

        System.out.printf("\nEstimated Body Fat Percentage: %.2f%%\n\n", bodyFat);
    }
}
