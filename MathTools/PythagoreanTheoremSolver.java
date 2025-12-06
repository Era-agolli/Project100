package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class PythagoreanTheoremSolver {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Pythagorean Theorem Solver ---");
        System.out.println("1. Find Hypotenuse (c)");
        System.out.println("2. Find Missing Leg (a or b)");

        int choice = InputHelper.readInt(scanner, "Choose an option: ");

        switch (choice) {
            case 1 -> {
                double a = InputHelper.readDouble(scanner, "Enter side a: ");
                double b = InputHelper.readDouble(scanner, "Enter side b: ");
                double c = Math.sqrt(a * a + b * b);
                System.out.println("Hypotenuse (c): " + String.format("%.4f", c));
            }
            case 2 -> {
                double c = InputHelper.readDouble(scanner, "Enter hypotenuse (c): ");
                double knownLeg = InputHelper.readDouble(scanner, "Enter known leg (a or b): ");

                if (knownLeg >= c) {
                    System.out.println("Error: A leg cannot be equal to or larger than the hypotenuse.");
                    return;
                }

                double missing = Math.sqrt(c * c - knownLeg * knownLeg);
                System.out.println("Missing leg: " + String.format("%.4f", missing));
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}
