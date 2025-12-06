package Games;

import java.util.Scanner;

public class QuizGame {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("\n--- Quiz Game ---\n");
        System.out.println("Answer each question by choosing A, B, C, or D.\n");

        String[] questions = {
                "1. What is the capital city of France?",
                "2. Which planet is commonly known as the Red Planet?",
                "3. What is the approximate value of PI?",
                "4. Who is the author of 'Romeo and Juliet'?",
                "5. What is the fastest land animal?",
                "6. Which gas do plants absorb from the atmosphere?",
                "7. What is the largest ocean on Earth?",
                "8. Who painted the Mona Lisa?",
                "9. What is the powerhouse of the cell?",
                "10. Which metal is liquid at room temperature?"
        };

        String[][] options = {
                {"A) Paris", "B) London", "C) Rome", "D) Berlin"},
                {"A) Venus", "B) Earth", "C) Mars", "D) Jupiter"},
                {"A) 2.14", "B) 3.14", "C) 4.14", "D) 5.14"},
                {"A) Charles Dickens", "B) William Shakespeare", "C) J.R.R. Tolkien", "D) Mark Twain"},
                {"A) Cheetah", "B) Lion", "C) Horse", "D) Tiger"},
                {"A) Oxygen", "B) Nitrogen", "C) Carbon Dioxide", "D) Hydrogen"},
                {"A) Indian Ocean", "B) Pacific Ocean", "C) Atlantic Ocean", "D) Arctic Ocean"},
                {"A) Leonardo da Vinci", "B) Michelangelo", "C) Pablo Picasso", "D) Vincent van Gogh"},
                {"A) Chloroplast", "B) Nucleus", "C) Mitochondria", "D) Ribosome"},
                {"A) Iron", "B) Mercury", "C) Silver", "D) Gold"}
        };

        char[] answers = {'A', 'C', 'B', 'B', 'A', 'C', 'B', 'A', 'C', 'B'};

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            for (String opt : options[i]) {
                System.out.println(opt);
            }

            System.out.print("Your answer: ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.length() == 1 && input.charAt(0) == answers[i]) {
                System.out.println("✔ Correct answer!\n");
                score++;
            } else {
                System.out.println("✖ Incorrect. The correct answer is: " + answers[i] + "\n");
            }
        }

        System.out.println("Quiz complete!");
        System.out.println("Your final score: " + score + "/10");
    }
}
