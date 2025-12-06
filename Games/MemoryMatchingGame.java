package Games;

import java.util.*;

public class MemoryMatchingGame {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n--- Memory Matching Game ---\n");
        System.out.println("Try to match all the pairs to win!\n");

        // Card values (pairs)
        List<String> cards = new ArrayList<>(Arrays.asList(
                "A", "A", "B", "B", "C", "C", "D", "D"
        ));

        // Shuffle the cards
        Collections.shuffle(cards, random);

        // Game board state: hidden by default
        boolean[] revealed = new boolean[cards.size()];

        int matchedPairs = 0;

        while (matchedPairs < cards.size() / 2) {
            printBoard(cards, revealed);

            System.out.print("Choose your first card (1-8): ");
            int first = readIndex(scanner);
            System.out.print("Choose your second card (1-8): ");
            int second = readIndex(scanner);

            if (first == second) {
                System.out.println("You cannot select the same card twice.\n");
                continue;
            }

            System.out.println("\nYou flipped:");
            System.out.println("Card " + first + ": " + cards.get(first - 1));
            System.out.println("Card " + second + ": " + cards.get(second - 1));

            if (cards.get(first - 1).equals(cards.get(second - 1))) {
                System.out.println("✔ You found a matching pair!\n");
                revealed[first - 1] = true;
                revealed[second - 1] = true;
                matchedPairs++;
            } else {
                System.out.println("✖ Not a match. Give it another try!\n");
            }
        }

        printBoard(cards, revealed);
        System.out.println("🎉 Congratulations! You matched all the pairs!");
    }

    private int readIndex(Scanner scanner) {
        while (true) {
            try {
                int index = Integer.parseInt(scanner.nextLine().trim());
                if (index >= 1 && index <= 8) return index;
            } catch (NumberFormatException ignored) {}
            System.out.print("Invalid input. Please enter a number from 1 to 8: ");
        }
    }

    private void printBoard(List<String> cards, boolean[] revealed) {
        System.out.println("\nCurrent Board:");
        for (int i = 0; i < cards.size(); i++) {
            if (revealed[i]) {
                System.out.print("[" + cards.get(i) + "] ");
            } else {
                System.out.print("[*] ");
            }

            if ((i + 1) % 4 == 0) System.out.println();
        }
        System.out.println();
}}
