package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class CalorieEstimator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Daily Calorie Estimator ---\n");

        double weight = InputHelper.readDouble(scanner, "Enter your weight in kg: ");
        double height = InputHelper.readDouble(scanner, "Enter your height in cm: ");
        int age = InputHelper.readInt(scanner, "Enter your age in years: ");
        char gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");

        while (gender != 'M' && gender != 'F') {
            System.out.println("Invalid input. Enter M or F.");
            gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        }

        // Calculate BMR
        double bmr = (gender == 'M')
                ? 10 * weight + 6.25 * height - 5 * age + 5
                : 10 * weight + 6.25 * height - 5 * age - 161;

        // Choose activity level
        System.out.println("\nSelect your activity level:");
        System.out.println("1) Sedentary (little or no exercise)");
        System.out.println("2) Lightly active (light exercise 1-3 days/week)");
        System.out.println("3) Moderately active (moderate exercise 3-5 days/week)");
        System.out.println("4) Very active (hard exercise 6-7 days/week)");
        System.out.println("5) Extra active (very hard exercise or physical job)");

        int activityChoice = InputHelper.readInt(scanner, "Enter 1-5: ");

        double activityMultiplier = switch (activityChoice) {
            case 1 -> 1.2;
            case 2 -> 1.375;
            case 3 -> 1.55;
            case 4 -> 1.725;
            case 5 -> 1.9;
            default -> 1.2;
        };

        double dailyCalories = bmr * activityMultiplier;
        System.out.printf("\nEstimated daily calorie needs: %.2f calories/day\n\n", dailyCalories);
    }
}
