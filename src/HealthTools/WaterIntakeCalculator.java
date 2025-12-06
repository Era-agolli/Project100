package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class WaterIntakeCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Daily Water Intake Calculator ---\n");

        double weight = InputHelper.readDouble(scanner, "Enter your weight in kg: ");
        double activityMinutes = InputHelper.readDouble(scanner, "Enter minutes of physical activity per day: ");

        // Basic water intake: 35 ml per kg of body weight
        double waterMl = weight * 35;

        // Add water for physical activity: ~12 ml per kg per 30 min exercise
        waterMl += weight * 12 * (activityMinutes / 30.0);

        double waterLiters = waterMl / 1000.0;

        System.out.printf("\nRecommended daily water intake: %.2f liters\n\n", waterLiters);
    }
}
