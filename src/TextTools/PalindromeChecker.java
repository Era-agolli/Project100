package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class PalindromeChecker {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Palindrome Checker ---");

        String text = InputHelper.readString(scanner, "Enter text: ");

        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(clean).reverse().toString();

        if (clean.equals(reversed)) {
            System.out.println("It IS a palindrome!");
        } else {
            System.out.println("It is NOT a palindrome.");
        }
    }
}
