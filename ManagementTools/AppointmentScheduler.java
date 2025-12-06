package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentScheduler {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> appointments = new ArrayList<>();

        System.out.println("\n--- Appointment Scheduler ---");

        while (true) {
            System.out.println("\n1. Add Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Remove Appointment");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String app = InputHelper.readString(scanner, "Enter appointment description: ");
                    appointments.add(app);
                    System.out.println("Appointment added.");
                }
                case 2 -> {
                    System.out.println("\n--- Appointments ---");
                    if (appointments.isEmpty()) System.out.println("No appointments.");
                    else {
                        for (int i = 0; i < appointments.size(); i++)
                            System.out.println((i + 1) + ". " + appointments.get(i));
                    }
                }
                case 3 -> {
                    System.out.print("Enter appointment number to remove: ");
                    int index = InputHelper.readInt(scanner,"");
                    if (index < 1 || index > appointments.size()) System.out.println("Invalid number.");
                    else {
                        appointments.remove(index - 1);
                        System.out.println("Appointment removed.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting scheduler...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
