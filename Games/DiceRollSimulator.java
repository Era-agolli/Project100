package Games;


import java.util.Random;
import java.util.Scanner;

public class DiceRollSimulator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n--- Dice Roll Simulator ---");
        System.out.print("How many dice would you like to roll? ");
        int diceCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("\nRolling " + diceCount + " dice...\n");

        for (int i = 1; i <= diceCount; i++) {
            int roll = random.nextInt(6) + 1;
            System.out.println("Result of dice " + i + ": " + roll);
        }
    }
}
