package FileTools;

import java.io.*;
import java.util.Scanner;

public class TextFormatter {

    public void run() {
        System.out.println("\n--- Text Formatter ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputPath = scanner.nextLine();

        System.out.print("Enter output file path: ");
        String outputPath = scanner.nextLine();

        System.out.println("Choose formatting option:");
        System.out.println("1. UPPERCASE");
        System.out.println("2. lowercase");
        System.out.println("3. Capitalize Words");
        System.out.println("4. Remove Extra Spaces");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(scanner.nextLine());

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: File does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) {

            String line;

            while ((line = br.readLine()) != null) {

                switch (choice) {
                    case 1 -> line = line.toUpperCase();
                    case 2 -> line = line.toLowerCase();
                    case 3 -> line = capitalizeWords(line);
                    case 4 -> line = removeExtraSpaces(line);
                    default -> {
                        System.out.println("Invalid option.");
                        return;
                    }
                }

                bw.write(line);
                bw.newLine();
            }

            System.out.println("Text formatted successfully!");

        } catch (Exception e) {
            System.out.println("Error formatting text: " + e.getMessage());
        }
    }

    private String capitalizeWords(String line) {
        String[] words = line.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (String w : words) {
            if (w.length() > 0) {
                sb.append(Character.toUpperCase(w.charAt(0)))
                        .append(w.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return sb.toString().trim();
    }

    private String removeExtraSpaces(String line) {
        return line.trim().replaceAll("\\s+", " ");
    }
}

