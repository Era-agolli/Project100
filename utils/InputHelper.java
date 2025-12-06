package utils;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHelper {
    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine();  // read the whole line
                return Integer.parseInt(line.trim()); // parse integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid number.");
            }
        }
    }



    public static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                String line = scanner.nextLine();
                return Double.parseDouble(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a valid number.");
            }
        }
    }

    public static String readString(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }



    public static char readChar(Scanner scanner, String prompt) {
        System.out.println(prompt);
        while (true){
            String input = scanner.nextLine().trim();
            if (input.length() == 1){
                return input.charAt(0);
            }else {
                System.out.println("Invalid input.Enter a single character: ");
            }
        }
    }
}
