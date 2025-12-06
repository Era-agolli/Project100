package FileTools;

import java.io.File;
import java.util.Scanner;

public class FileRenameUtility {

    public void run() {
        System.out.println("\n--- File Rename Utility ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path to rename: ");
        String oldPath = scanner.nextLine();

        System.out.print("Enter new file name: ");
        String newName = scanner.nextLine();

        File oldFile = new File(oldPath);

        if (!oldFile.exists()) {
            System.out.println("Error: File does not exist.");
            return;
        }

        File newFile = new File(oldFile.getParent(), newName);

        if (newFile.exists()) {
            System.out.println("Error: A file with this name already exists.");
            return;
        }

        boolean success = oldFile.renameTo(newFile);

        if (success) {
            System.out.println("File renamed successfully!");
            System.out.println("New path: " + newFile.getAbsolutePath());
        } else {
            System.out.println("Error: Could not rename the file.");
        }
    }
}
