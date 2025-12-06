package Games;


import java.util.Random;
import java.util.Scanner;

public class CoinTossSimulator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n--- Coin Toss Simulator: Guess the Outcome ---");

        while (true) {
            System.out.print("Enter your guess(Heads or Tails), or type 'exit' to quit: ");
            String guess = scanner.nextLine().trim().toLowerCase();

            if (guess.equals("exit")) break;
            if (!guess.equals("heads") && !guess.equals("tails")) {
                System.out.println("Invalid input! Please enter either Heads or Tails.\n");
                continue;
            }

            String result = random.nextBoolean() ? "heads" : "tails";
            System.out.println("The coin landed on: " + result);

            if (guess.equals(result)) {
                System.out.println("✔ Correct! Your guess matches the result\n");
            } else {
                System.out.println("✖ Incorrect! Better luck next time.\n");
            }
        }
    }
}

