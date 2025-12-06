package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class TemperatureConversionTable {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Temperature Conversion Table ---");

        int start = InputHelper.readInt(scanner, "Enter starting Celsius: ");
        int end = InputHelper.readInt(scanner, "Enter ending Celsius: ");

        System.out.printf("%-10s %-12s %-12s%n", "Celsius", "Fahrenheit", "Kelvin");

        for (int c = start; c <= end; c++) {
            double f = (c * 9 / 5.0) + 32;
            double k = c + 273.15;
            System.out.printf("%-10d %-12.2f %-12.2f%n", c, f, k);
        }
    }
}

