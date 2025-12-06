package FileTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class FileComparator {

    public void run() {
        System.out.println("\n--- File Comparator ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first file path: ");
        String file1Path = scanner.nextLine();

        System.out.print("Enter second file path: ");
        String file2Path = scanner.nextLine();

        File f1 = new File(file1Path);
        File f2 = new File(file2Path);

        if (!f1.exists() || !f2.exists()) {
            System.out.println("One or both files do not exist.");
            return;
        }

        try (InputStream s1 = new FileInputStream(f1);
             InputStream s2 = new FileInputStream(f2)) {

            int b1, b2;
            long index = 0;

            while ((b1 = s1.read()) != -1) {
                b2 = s2.read();

                if (b1 != b2) {
                    System.out.println("Files differ at byte index: " + index);
                    return;
                }
                index++;
            }

            if (s2.read() != -1) {
                System.out.println("Files differ in size.");
            } else {
                System.out.println("The files are IDENTICAL.");
            }

        } catch (Exception e) {
            System.out.println("Error comparing files: " + e.getMessage());
        }
    }
}

