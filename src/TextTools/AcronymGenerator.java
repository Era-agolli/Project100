package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class AcronymGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Acronym Generator ---");

        String phrase = InputHelper.readString(scanner, "Enter a phrase: ");

        String[] words = phrase.trim().split("\\s+");
        StringBuilder acronym = new StringBuilder();

        for (String w : words) {
            acronym.append(Character.toUpperCase(w.charAt(0)));
        }

        System.out.println("Acronym: " + acronym);
    }
}

