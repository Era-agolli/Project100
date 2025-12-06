package TableGenerators;

import utils.InputHelper;

import java.util.Arrays;
import java.util.Scanner;

public class NameSorter {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Name Sorter ---");

        int count = InputHelper.readInt(scanner, "How many names? ");

        String[] names = new String[count];

        for (int i = 0; i < count; i++) {
            names[i] = InputHelper.readString(scanner, "Enter name #" + (i + 1) + ": ");
        }

        Arrays.sort(names);

        System.out.println("\nSorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

