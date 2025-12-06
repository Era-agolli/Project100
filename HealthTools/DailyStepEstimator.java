package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class DailyStepEstimator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Daily Step Estimator ---\n");

        double distanceKm = InputHelper.readDouble(scanner, "Enter your average daily walking distance in kilometers: ");
        double strideLengthCm = InputHelper.readDouble(scanner, "Enter your average stride length in centimeters: ");

        // Convert distance to cm
        double distanceCm = distanceKm * 1000 * 100;

        // Calculate steps
        int steps = (int) (distanceCm / strideLengthCm);

        System.out.printf("\nEstimated daily steps: %d steps\n\n", steps);
    }
}
