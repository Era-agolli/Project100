package Games;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public void run() {

        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "matrix", "dragon", "galaxy",
                          "computer", "horizon", "crystal", "velocity","eclipse",
                          "lantern", "whisper", "ember", "solitude", "cascade"};

        Random random = new Random();
        String word = words[random.nextInt(words.length)];

        StringBuilder display = new StringBuilder("_".repeat(word.length()));
        int attempts = 6;

        System.out.println("\n--- Hangman Game ---");

        while (attempts > 0) {
            System.out.println("Current Word: " + display);
            System.out.println("Remaining attempts: " + attempts);
            System.out.print("Enter a letter: ");

            char guess = scanner.next().toLowerCase().charAt(0);
            boolean found = false;

            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    display.setCharAt(i, guess);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("❌ Incorrect guess!");
                attempts--;
            } else {
                System.out.println("✔ Nice! You found a letter.");
            }

            if (display.toString().equals(word)) {
                System.out.println("\n🎉 Congratulations! You guessed the word: " + word);
                return;
            }
        }

        System.out.println("\n💀 Game over! The correct word was: " + word);
}}
