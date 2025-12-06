package FileTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileMerger {

    public void run() {
        System.out.println("\n--- File Merger ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first file path: ");
        String file1Path = scanner.nextLine();

        System.out.print("Enter second file path: ");
        String file2Path = scanner.nextLine();

        System.out.print("Enter output merged file path: ");
        String outputPath = scanner.nextLine();

        File f1 = new File(file1Path);
        File f2 = new File(file2Path);

        if (!f1.exists() || !f2.exists()) {
            System.out.println("Error: One or both input files do not exist.");
            return;
        }

        try (FileOutputStream fos = new FileOutputStream(outputPath)) {
            mergeFile(f1, fos);
            mergeFile(f2, fos);

            System.out.println("Files merged successfully!");
        } catch (Exception e) {
            System.out.println("Error merging files: " + e.getMessage());
        }
    }

    private void mergeFile(File file, FileOutputStream fos) throws IOException {
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}

