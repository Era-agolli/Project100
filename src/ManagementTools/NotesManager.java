package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotesManager {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<String> notes = new ArrayList<>();

        System.out.println("\n--- Notes Manager ---");

        while (true) {
            System.out.println("\n1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Delete Note");
            System.out.println("4. Exit");
            System.out.println("Choose an option:");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String note = InputHelper.readString(scanner, "Enter note: ");
                    notes.add(note);
                    System.out.println("Note added.");
                }
                case 2 -> {
                    System.out.println("\n--- Notes ---");
                    if (notes.isEmpty()) System.out.println("No notes saved.");
                    else {
                        for (int i = 0; i < notes.size(); i++)
                            System.out.println((i + 1) + ". " + notes.get(i));
                    }
                }
                case 3 -> {
                    int idx = InputHelper.readInt(scanner, "Note number to delete: ");
                    if (idx < 1 || idx > notes.size()) System.out.println("Invalid.");
                    else {
                        notes.remove(idx - 1);
                        System.out.println("Note removed.");
                    }
                }
                case 4 -> {
                    System.out.println("Exiting Notes Manager...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
