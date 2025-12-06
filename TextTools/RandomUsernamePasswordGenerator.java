package TextTools;

import utils.InputHelper;

import java.util.Random;
import java.util.Scanner;

public class RandomUsernamePasswordGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Random Username & Password Generator ---");

        String base = InputHelper.readString(scanner, "Enter a base word for username: ");
        int length = InputHelper.readInt(scanner, "Enter password length (min 6): ");

        if (length < 6) length = 6;

        String username = generateUsername(base);
        String password = generatePassword(length);

        System.out.println("\nGenerated Username: " + username);
        System.out.println("Generated Password: " + password);
    }

    private String generateUsername(String base) {
        Random r = new Random();
        return base.toLowerCase() + "_" + (r.nextInt(900) + 100);
    }

    private String generatePassword(int length) {
        Random r = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&*?";
        StringBuilder pass = new StringBuilder();

        for (int i = 0; i < length; i++) {
            pass.append(chars.charAt(r.nextInt(chars.length())));
        }

        return pass.toString();
    }
}

