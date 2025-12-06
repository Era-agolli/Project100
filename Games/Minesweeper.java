package Games;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {

    public void run() {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int size = 5;
        int mines = 5;

        char[][] board = new char[size][size];
        boolean[][] revealed = new boolean[size][size];
        boolean[][] mineLocations = new boolean[size][size];

        // Initialize
        for (int i = 0; i < size; i++)
            Arrays.fill(board[i], '0');

        // Place mines
        int placed = 0;
        while (placed < mines) {
            int r = random.nextInt(size);
            int c = random.nextInt(size);
            if (!mineLocations[r][c]) {
                mineLocations[r][c] = true;
                placed++;
            }
        }

        // Calculate numbers
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (mineLocations[r][c]) {
                    board[r][c] = '*';
                } else {
                    int count = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int nr = r + i, nc = c + j;
                            if (nr >= 0 && nr < size && nc >= 0 && nc < size)
                                if (mineLocations[nr][nc]) count++;
                        }
                    }
                    board[r][c] = (char) ('0' + count);
                }
            }
        }

        System.out.println("\n--- Minesweeper Game ---");

        while (true) {
            printBoard(board, revealed);

            System.out.print("Enter a row number (0–4): ");
            int rr = scanner.nextInt();
            System.out.print("Enter a column number (0–4): ");
            int cc = scanner.nextInt();

            if (rr < 0 || rr >= size || cc < 0 || cc >= size) {
                System.out.println("Invalid position! Please try again.");
                continue;
            }

            if (revealed[rr][cc]) {
                System.out.println("This spot has already been revealed!");
                continue;
            }

            revealed[rr][cc] = true;

            if (mineLocations[rr][cc]) {
                printBoard(board, revealed);
                System.out.println("💥 BOOM! You stepped on a mine! Game over!");
                return;
            }

            if (isWin(revealed, mineLocations)) {
                printBoard(board, revealed);
                System.out.println("🎉 Congratulations! You successfully cleared all safe titles!");
                return;
            }
        }
    }

    private void printBoard(char[][] board, boolean[][] revealed) {
        System.out.println();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (revealed[r][c]) System.out.print(" " + board[r][c] + " ");
                else System.out.print(" # ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isWin(boolean[][] rev, boolean[][] mines) {
        for (int r = 0; r < rev.length; r++)
            for (int c = 0; c < rev[0].length; c++)
                if (!rev[r][c] && !mines[r][c]) return false;
        return true;
}}

