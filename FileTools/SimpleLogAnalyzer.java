package FileTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class SimpleLogAnalyzer {

    public void run() {
        System.out.println("\n--- Simple Log Analyzer ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter log file path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (!file.exists()) {
            System.out.println("Error: Log file does not exist.");
            return;
        }

        int info = 0, warning = 0, error = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {

                line = line.toUpperCase();

                if (line.contains("INFO")) info++;
                if (line.contains("WARNING") || line.contains("WARN")) warning++;
                if (line.contains("ERROR")) error++;
            }

            System.out.println("INFO: " + info);
            System.out.println("WARNING: " + warning);
            System.out.println("ERROR: " + error);

        } catch (Exception e) {
            System.out.println("Error analyzing log file: " + e.getMessage());
        }
    }
}

