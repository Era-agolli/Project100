package Games;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public void run() {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[3][3];

        for (int i=0; i<3; i++)
            Arrays.fill(board[i], '-');

        char current = 'X';

        System.out.println("\n--- Tic Tac Toe ---");
        System.out.println("Player X and Player O take turns.Get three in a row to win!\n");

        while (true) {

            printBoard(board);

            System.out.println("Player " + current + "'s turn");
            System.out.print("Enter row (0–2): ");
            int r = sc.nextInt();
            System.out.print("Enter col (0–2): ");
            int c = sc.nextInt();

            if (r < 0 || r > 2 || c < 0 || c > 2) {
                System.out.println("Invalid position! Please enter a row and column between 0 and 2.\n");
                continue;
            }

            if (board[r][c] != '-') {
                System.out.println("Cell already taken! Choose another cell.\n.");
                continue;
            }

            board[r][c] = current;

            if (win(board, current)) {
                printBoard(board);
                System.out.println("🎉 Congratulations! Player " + current + " wins the game!");
                return;
            }

            if (full(board)) {
                printBoard(board);
                System.out.println("It's a draw! Well played.");
                return;
            }

            current = (current == 'X') ? 'O' : 'X';
        }
    }

    private boolean win(char[][] board, char p) {
        for (int i=0; i<3; i++) {
            if (board[i][0]==p && board[i][1]==p && board[i][2]==p) return true;
            if (board[0][i]==p && board[1][i]==p && board[2][i]==p) return true;
        }
        return (board[0][0]==p && board[1][1]==p && board[2][2]==p) ||
                (board[0][2]==p && board[1][1]==p && board[2][0]==p);
    }

    private boolean full(char[][] board) {
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if (board[i][j]=='-') return false;
        return true;
    }

    private void printBoard(char[][] board) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[] args){
        new TicTacToe().run();
}}
