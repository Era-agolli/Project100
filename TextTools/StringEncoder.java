package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class StringEncoder {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- String Encoder ---");

        String text = InputHelper.readString(scanner, "Enter text to encode: ");
        int shift = InputHelper.readInt(scanner, "Enter shift amount (number): ");

        StringBuilder encoded = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encoded.append(c);
        }

        System.out.println("Encoded text: " + encoded);
    }
}

