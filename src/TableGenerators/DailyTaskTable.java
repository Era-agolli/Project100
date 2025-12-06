package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class DailyTaskTable {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Daily Task Table ---");

        String[] tasks = new String[24];

        for (int i = 0; i < 24; i++) {
            tasks[i] = InputHelper.readString(scanner,"Enter task for hour " + i + ": ");
        }

        System.out.println("\n--- Your Daily Tasks ---");
        for (int i = 0; i < 24; i++) {
            System.out.println("Hour " + i + ": " + tasks[i]);
        }
    }
}
