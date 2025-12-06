package HealthTools;

import java.util.Scanner;
import utils.InputHelper;

public class HeartRateZoneCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Heart Rate Zone Calculator ---\n");

        int age = InputHelper.readInt(scanner, "Enter your age: ");
        char gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");

        while (gender != 'M' && gender != 'F') {
            System.out.println("Invalid input. Enter M for male or F for female.");
            gender = InputHelper.readChar(scanner, "Enter your gender (M/F): ");
        }

        int maxHeartRate = 220 - age;

        double[] zones = {
                maxHeartRate * 0.5,
                maxHeartRate * 0.6,
                maxHeartRate * 0.7,
                maxHeartRate * 0.8,
                maxHeartRate * 0.9
        };

        System.out.println("\nHeart Rate Zones (beats per minute):");
        System.out.printf("Very Light: %.0f - %.0f\n", 0.0, zones[0]);
        System.out.printf("Light: %.0f - %.0f\n", zones[0], zones[1]);
        System.out.printf("Moderate: %.0f - %.0f\n", zones[1], zones[2]);
        System.out.printf("Hard: %.0f - %.0f\n", zones[2], zones[3]);
        System.out.printf("Maximum: %.0f - %.0f\n\n", zones[3], zones[4]);
    }
}
