package TextTools;

import utils.InputHelper;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWordRemover {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Duplicate Word Remover ---");

        String text = InputHelper.readString(scanner, "Enter a sentence: ");

        String[] words = text.toLowerCase().split("\\s+");
        Set<String> uniqueWords = new LinkedHashSet<>();

        for (String w : words) {
            uniqueWords.add(w);
        }

        System.out.println("Clean sentence:");
        for (String w : uniqueWords) {
            System.out.print(w + " ");
        }
        System.out.println();
    }
}

