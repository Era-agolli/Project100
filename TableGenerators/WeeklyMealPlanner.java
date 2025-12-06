package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class WeeklyMealPlanner {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Weekly Meal Planner ---");

        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        String[] meals = new String[7];

        for (int i = 0; i < 7; i++) {
            meals[i] = InputHelper.readString(scanner, "Enter meal for " + days[i] + ": ");
        }

        System.out.println("\nYour Weekly Meal Plan:");
        for (int i = 0; i < 7; i++) {
            System.out.println(days[i] + ": " + meals[i]);
        }
    }
}
