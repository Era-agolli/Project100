package TimeDateTools;

import utils.InputHelper;

import java.util.Scanner;

public class WorkingHoursCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Working Hours Calculator ---");

        int employees = InputHelper.readInt(scanner, "Enter number of employees: ");
        double[][] hours = new double[employees][7];
        String[] names = new String[employees];

        for (int i = 0; i < employees; i++) {
            names[i] = InputHelper.readString(scanner, "Enter employee name: ");
            double total = 0;
            for (int d = 0; d < 7; d++) {
                hours[i][d] = InputHelper.readDouble(scanner, "Hours worked on day " + (d + 1) + ": ");
                total += hours[i][d];
            }
            System.out.println(names[i] + " total hours: " + total);
        }
    }
}
