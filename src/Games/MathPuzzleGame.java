package Games;

import java.util.Random;
import java.util.Scanner;

public class MathPuzzleGame {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int totalQuestions = 10; // fixed number of questions

        System.out.println("\n--- Math Puzzle Game ---");
        System.out.println("Solve 10 math questions and earn points.\n");

        String[] operators = {"+", "-", "*", "/"};

        for (int q = 1; q <= totalQuestions; q++) {
            int a = random.nextInt(20) + 1;
            int b = random.nextInt(20) + 1;
            String op = operators[random.nextInt(operators.length)];
            double correct;

            // Determine correct answer
            switch (op) {
                case "+" -> correct = a + b;
                case "-" -> correct = a - b;
                case "*" -> correct = a * b;
                case "/" -> {
                    while (b == 0) b = random.nextInt(20) + 1; // avoid division by zero
                    correct = Math.round((double) a / b * 100.0) / 100.0; // round to 2 decimals
                }
                default -> correct = 0;
            }

            // Generate multiple-choice options
            double[] options = new double[4];
            options[0] = correct;
            for (int i = 1; i < 4; i++) {
                options[i] = correct + random.nextInt(10) - 5;
                if (options[i] == correct) options[i] += 1;
            }

            // Shuffle options
            for (int i = 0; i < options.length; i++) {
                int j = random.nextInt(options.length);
                double temp = options[i];
                options[i] = options[j];
                options[j] = temp;
            }

            // Display question
            System.out.println("Question " + q + ": " + a + " " + op + " " + b + " = ?");
            System.out.println("A) " + options[0] + "  B) " + options[1] + "  C) " + options[2] + "  D) " + options[3]);
            System.out.print("Enter your answer (A-D): ");

            String input = scanner.nextLine().trim().toUpperCase();

            int idx = switch (input) {
                case "A" -> 0;
                case "B" -> 1;
                case "C" -> 2;
                case "D" -> 3;
                default -> -1;
            };

            if (idx == -1) {
                System.out.println("Invalid input. This question will be skipped.\n");
                continue;
            }

            // Check answer
            if (Math.abs(options[idx] - correct) < 0.01) {
                System.out.println("✔ Correct!\n");
                score++;
            } else {
                System.out.println("✖ Incorrect! The correct answer is: " + correct + "\n");
            }
        }

        // Display final score
        System.out.println("🎉 Game Over!");
        System.out.println("Your final score is: " + score + " out of " + totalQuestions);
    }
    }

