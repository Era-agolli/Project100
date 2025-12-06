package FileTools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class FileDecryptionTool {

    public void run() {
        System.out.println("\n--- File Decryption Tool (XOR Decryption) ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter encrypted file path: ");
        String inputPath = scanner.nextLine();

        System.out.print("Enter output decrypted file path: ");
        String outputPath = scanner.nextLine();

        System.out.print("Enter decryption key (same used to encrypt): ");
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
                fos.write(data ^ key); // XOR decrypt
            }

            System.out.println("File decrypted successfully!");
        } catch (Exception e) {
            System.out.println("Error decrypting file: " + e.getMessage());
        }
    }
}
