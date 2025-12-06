package FileTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileEncryptionTool {

    public void run() {
        System.out.println("\n--- File Encryption Tool (XOR Encryption) ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file path to encrypt: ");
        String inputPath = scanner.nextLine();

        System.out.print("Enter output encrypted file path: ");
        String outputPath = scanner.nextLine();

        System.out.print("Enter encryption key (a single character): ");
        char key = scanner.nextLine().charAt(0);

        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: File does not exist.");
            return;
        }

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputPath)) {

            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ key); // XOR encryption
            }

            System.out.println("File encrypted successfully!");
        } catch (Exception e) {
            System.out.println("Error encrypting file: " + e.getMessage());
        }
    }
}

