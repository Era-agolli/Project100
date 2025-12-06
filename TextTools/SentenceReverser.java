package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class SentenceReverser {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Sentence Reverser ---");

        String sentence = InputHelper.readString(scanner, "Enter a sentence: ");

        StringBuilder reversed = new StringBuilder(sentence).reverse();

        System.out.println("Reversed: " + reversed);
    }
}

