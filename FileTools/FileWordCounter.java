package FileTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class FileWordCounter {

    public void run() {
        System.out.println("\n--- File Word Counter ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Error: File does not exist.");
            return;
        }

        int wordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty()) {
                    wordCount += words.length;
                }
            }

            System.out.println("Total Words: " + wordCount);

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
