package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class MultiplicationTableGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Multiplication Table Generator ---");

        int n = InputHelper.readInt(scanner, "Generate multiplication table up to: ");

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }
    }
}