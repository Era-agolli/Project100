package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class EmployeeWorkHoursTable {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Employee Work Hours Table ---");

        int employees = InputHelper.readInt(scanner,"Enter number of employees: ");
        int days = 7; // one-week table

        String[] names = new String[employees];
        double[][] hours = new double[employees][days];

        for (int i = 0; i < employees; i++) {
            names[i] = InputHelper.readString(scanner,"Enter employee #" + (i + 1) + " name: ");

            for (int d = 0; d < days; d++) {
                hours[i][d] = InputHelper.readDouble(
                        scanner,"Hours worked by " + names[i] + " on day " + (d + 1) + ": "
                );
            }
        }

        System.out.println("\n--- Weekly Work Hours Summary ---");
        for (int i = 0; i < employees; i++) {
            System.out.print(names[i] + ": ");

            double total = 0;
            for (int d = 0; d < days; d++) {
                total += hours[i][d];
                System.out.print(hours[i][d] + " ");
            }

            System.out.println(" | Total: " + total + " hours");
        }
    }

}
