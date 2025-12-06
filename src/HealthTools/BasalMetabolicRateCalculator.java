package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class  BasalMetabolicRateCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Basal Metabolic Rate (BMR) Calculator ---\n");

        // Input weight
        double weight = InputHelper.readDouble(scanner, "Enter your weight in kilograms (kg): ");

        // Input height
        double height = InputHelper.readDouble(scanner, "Enter your height in centimeters (cm): ");

        // Input age
        int age = InputHelper.readInt(scanner, "Enter your age in years: ");

        // Input gender
        char gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");

        // Validate gender
        while (gender != 'M' && gender != 'F') {
            System.out.println("Invalid input. Please enter M for male or F for female.");
            gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        }

        // Calculate BMR (Mifflin-St Jeor Equation)
        double bmr;
        if (gender == 'M') {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        System.out.printf("\nYour Basal Metabolic Rate (BMR) is: %.2f calories/day\n", bmr);
        System.out.println("This is the number of calories your body needs at rest to maintain basic functions.\n");
    }
}


