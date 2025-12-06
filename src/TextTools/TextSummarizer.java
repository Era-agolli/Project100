package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class TextSummarizer {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Text Summarizer ---");

        String text = InputHelper.readString(scanner, "Enter your text: ");
        int sentencesToKeep = InputHelper.readInt(scanner, "How many sentences to keep? ");

        String[] sentences = text.split("(?<=[.!?])\\s*");

        System.out.println("\n--- Summary ---");
        for (int i = 0; i < Math.min(sentencesToKeep, sentences.length); i++) {
            System.out.print(sentences[i] + " ");
        }
        System.out.println();
    }
}

