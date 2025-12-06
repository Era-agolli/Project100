package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HabitTracker {

    static class Habit {
        String name;
        int streak;

        Habit(String name) {
            this.name = name;
            this.streak = 0;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Habit> habits = new ArrayList<>();

        System.out.println("\n--- Habit Tracker ---");

        while (true) {
            System.out.println("\n1. Add Habit");
            System.out.println("2. Mark Habit as Done");
            System.out.println("3. View Habits & Streaks");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String habitName = InputHelper.readString(scanner, "Enter habit name: ");
                    habits.add(new Habit(habitName));
                    System.out.println("Habit added.");
                }
                case 2 -> {
                    if (habits.isEmpty()) {
                        System.out.println("No habits to update.");
                        break;
                    }

                    System.out.println("\n--- Your Habits ---");
                    for (int i = 0; i < habits.size(); i++)
                        System.out.println((i + 1) + ". " + habits.get(i).name);

                    System.out.print("Enter number of habit to mark done: ");
                    int index = InputHelper.readInt(scanner,"");

                    if (index < 1 || index > habits.size()) System.out.println("Invalid.");
                    else {
                        habits.get(index - 1).streak++;
                        System.out.println("Habit streak increased.");
                    }
                }
                case 3 -> {
                    System.out.println("\n--- Habit List ---");
                    if (habits.isEmpty()) System.out.println("No habits added.");
                    else {
                        for (Habit h : habits)
                            System.out.println(h.name + " | Streak: " + h.streak);
                    }
                }
                case 4 -> {
                    System.out.println("Exiting Habit Tracker...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
