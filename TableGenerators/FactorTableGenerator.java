package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class FactorTableGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Factor Table Generator ---");

        int start = InputHelper.readInt(scanner, "Enter start number: ");
        int end = InputHelper.readInt(scanner, "Enter end number: ");

        for (int n = start; n <= end; n++) {
            System.out.print("Factors of " + n + ": ");
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

