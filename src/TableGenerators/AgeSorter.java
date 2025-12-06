package TableGenerators;

import utils.InputHelper;

import java.util.Arrays;
import java.util.Scanner;

public class AgeSorter {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Age Sorter ---");

        int count = InputHelper.readInt(scanner,"How many ages do you want to enter? ");
        int[] ages = new int[count];

        for (int i = 0; i < count; i++) {
            ages[i] = InputHelper.readInt(scanner,"Enter age #" + (i + 1) + ": ");
        }

        Arrays.sort(ages);

        System.out.println("\nSorted ages:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
}
