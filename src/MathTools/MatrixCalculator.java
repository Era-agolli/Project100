package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class MatrixCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Matrix Calculator ---");

        System.out.println("1. Matrix Addition");
        System.out.println("2. Matrix Subtraction");
        System.out.println("3. Matrix Multiplication");

        int choice = InputHelper.readInt(scanner, "Choose an operation: ");

        int rows1 = InputHelper.readInt(scanner, "Enter rows for Matrix 1: ");
        int cols1 = InputHelper.readInt(scanner, "Enter columns for Matrix 1: ");

        double[][] A = readMatrix(scanner, rows1, cols1, "Matrix 1");

        int rows2 = InputHelper.readInt(scanner, "Enter rows for Matrix 2: ");
        int cols2 = InputHelper.readInt(scanner, "Enter columns for Matrix 2: ");

        double[][] B = readMatrix(scanner, rows2, cols2, "Matrix 2");

        switch (choice) {
            case 1 -> {
                if (rows1 != rows2 || cols1 != cols2) {
                    System.out.println("Matrices must have the same dimensions for addition.");
                    return;
                }
                printMatrix(add(A, B));
            }
            case 2 -> {
                if (rows1 != rows2 || cols1 != cols2) {
                    System.out.println("Matrices must have the same dimensions for subtraction.");
                    return;
                }
                printMatrix(subtract(A, B));
            }
            case 3 -> {
                if (cols1 != rows2) {
                    System.out.println("Columns of Matrix 1 must match rows of Matrix 2 for multiplication.");
                    return;
                }
                printMatrix(multiply(A, B));
            }
            default -> System.out.println("Invalid choice.");
        }
    }

    private double[][] readMatrix(Scanner scanner, int rows, int cols, String name) {
        System.out.println("Enter values for " + name + ":");
        double[][] matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = InputHelper.readDouble(scanner, "Value [" + i + "][" + j + "]: ");
            }
        }
        return matrix;
    }

    private double[][] add(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] + B[i][j];

        return result;
    }

    private double[][] subtract(double[][] A, double[][] B) {
        int r = A.length, c = A[0].length;
        double[][] result = new double[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                result[i][j] = A[i][j] - B[i][j];

        return result;
    }

    private double[][] multiply(double[][] A, double[][] B) {
        int r1 = A.length, c1 = A[0].length, c2 = B[0].length;
        double[][] result = new double[r1][c2];

        for (int i = 0; i < r1; i++)
            for (int j = 0; j < c2; j++)
                for (int k = 0; k < c1; k++)
                    result[i][j] += A[i][k] * B[k][j];

        return result;
    }

    private void printMatrix(double[][] m) {
        System.out.println("Result Matrix:");
        for (double[] row : m) {
            for (double v : row) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}

