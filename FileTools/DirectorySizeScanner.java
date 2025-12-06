package FileTools;

import java.io.File;
import java.util.Scanner;

public class DirectorySizeScanner {

    public void run(Scanner scanner) {
        System.out.println("\n--- Directory Size Scanner ---");

        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory.");
            return;
        }

        long size = getDirectorySize(dir);
        System.out.println("Total directory size: " + formatSize(size));
    }

    // Recursively calculate size
    private long getDirectorySize(File dir) {
        long size = 0;
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    size += f.length();
                } else if (f.isDirectory()) {
                    size += getDirectorySize(f);
                }
            }
        }
        return size;
    }

    // Convert bytes to readable format
    private String formatSize(long size) {
        if (size >= 1_000_000_000) return (size / 1_000_000_000) + " GB";
        if (size >= 1_000_000) return (size / 1_000_000) + " MB";
        if (size >= 1_000) return (size / 1_000) + " KB";
        return size + " bytes";
    }
}

