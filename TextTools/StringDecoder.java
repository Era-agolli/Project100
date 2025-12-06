package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class StringDecoder {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- String Decoder ---");

        String encoded = InputHelper.readString(scanner, "Enter encoded text (e.g., a3b1c2): ");

        StringBuilder decoded = new StringBuilder();

        for (int i = 0; i < encoded.length(); i++) {
            char ch = encoded.charAt(i);

            if (Character.isLetter(ch)) {
                int numStart = i + 1;
                StringBuilder number = new StringBuilder();

                while (numStart < encoded.length() && Character.isDigit(encoded.charAt(numStart))) {
                    number.append(encoded.charAt(numStart));
                    numStart++;
                }

                if (number.length() > 0) {
                    int repeat = Integer.parseInt(number.toString());
                    decoded.append(String.valueOf(ch).repeat(repeat));
                }

                i = numStart - 1;
            }
        }

        System.out.println("Decoded: " + decoded);
    }
}

