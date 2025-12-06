package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BasicToDoList {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> tasks = new ArrayList<>();

        System.out.println("\n--- Basic To-Do List ---");

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String task = InputHelper.readString(scanner, "Enter new task: ");
                    tasks.add(task);
                    System.out.println("Task added.");
                }
                case 2 -> {
                    System.out.println("\n--- Your Tasks ---");
                    if (tasks.isEmpty()) System.out.println("No tasks added yet.");
                    else {
                        for (int i = 0; i < tasks.size(); i++)
                            System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
                case 3 -> {
                    System.out.print("Enter task number to remove: ");
                    int index = InputHelper.readInt(scanner,"");
                    if (index < 1 || index > tasks.size()) System.out.println("Invalid number.");
                    else {
                        tasks.remove(index - 1);
                        System.out.println("Task removed.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting To-Do List...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
