package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class CalorieBurnEstimator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Calorie Burn Estimator ---\n");

        double weight = InputHelper.readDouble(scanner, "Enter your weight in kg: ");
        System.out.println("\nSelect exercise type:");
        System.out.println("1) Running (8 km/h)");
        System.out.println("2) Walking (5 km/h)");
        System.out.println("3) Cycling (moderate)");
        System.out.println("4) Swimming (moderate)");

        int choice = InputHelper.readInt(scanner, "Enter 1-4: ");
        double met = switch (choice) {
            case 1 -> 8.3;   // MET for running
            case 2 -> 3.8;   // MET for walking
            case 3 -> 6.8;   // MET for cycling
            case 4 -> 5.8;   // MET for swimming
            default -> 1.0;
        };

        double duration = InputHelper.readDouble(scanner, "Enter duration of exercise in minutes: ");

        // Calories burned formula: Calories = MET * weight(kg) * duration(hr)
        double caloriesBurned = met * weight * (duration / 60.0);

        System.out.printf("\nEstimated calories burned: %.2f calories\n\n", caloriesBurned);
    }
}
