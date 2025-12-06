package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class EquationSolver {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Equation Solver(Linear Equation ax + b = 0) ---");

        double a = InputHelper.readDouble(scanner, "Enter the coefficient a: ");
        double b = InputHelper.readDouble(scanner, "Enter the coefficient b: ");

        if (a == 0){
            if (b == 0){
                System.out.println("Infinite solutions (0x + 0 = 0). ");
            } else {
                System.out.println("No solution exists (0x + b = 0). ");
            }
        }else {
            double x = -b / a;
            System.out.println("Solution: The x is:  " + x );
        }
    }
}
