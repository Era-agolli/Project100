package Games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n--- Rock–Paper–Scissors Game ---\n");

        while (true) {
            System.out.print("Choose rock,paper, or scissors (or 'exit' to quit): ");
            String user = scanner.nextLine().trim().toLowerCase();

            if (user.equals("exit")) {
                System.out.println("Thanks for playing! Goodbye.");
                break;
            }

            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                System.out.println("Invalid choice.\n");
                continue;
            }

            String[] moves = {"rock", "paper", "scissors"};
            String computer = moves[random.nextInt(3)];

            System.out.println("Computer chose: " + computer);

            if (user.equals(computer)) {
                System.out.println("It's a tie! Try again.\n");
            }
            else if (
                    (user.equals("rock") && computer.equals("scissors")) ||
                            (user.equals("paper") && computer.equals("rock")) ||
                            (user.equals("scissors") && computer.equals("paper"))
            ) {
                System.out.println("You win this round!\n");
            }
            else {
                System.out.println("You lose this round! Try again!\n");
            }
        }
}}
