package FileTools;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class BackupFolderGenerator {

    public void run(Scanner scanner) { // pass scanner from Main
        System.out.println("\n--- Backup Folder Generator ---");

        System.out.print("Enter source folder path: ");
        String sourcePath = scanner.nextLine();

        System.out.print("Enter backup folder path: ");
        String backupPath = scanner.nextLine();

        File sourceDir = new File(sourcePath);
        File backupDir = new File(backupPath);

        if (!sourceDir.exists() || !sourceDir.isDirectory()) {
            System.out.println("Invalid source directory.");
            return;
        }

        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        File[] files = sourceDir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("The source directory is empty or unreadable.");
            return;
        }

        try {
            for (File file : files) {
                if (file.isFile()) {
                    Path dest = Paths.get(backupDir.getAbsolutePath(), file.getName());
                    Files.copy(file.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            System.out.println("Backup completed successfully!");
        } catch (Exception e) {
            System.out.println("Error during backup: " + e.getMessage());
        }
    }
}
