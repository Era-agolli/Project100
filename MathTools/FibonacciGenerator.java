package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class FibonacciGenerator {

    public void run(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Fibonacci Generator ---");

        int n = InputHelper.readInt(scanner, "Enter how many factorials to calculate: ");

        if (n <= 0){
            System.out.println("Enter a positive number: ");
            return;
        }

        int a = 0, b = 1;
        System.out.println("The Fibonacci series are : ");

        for (int i = 0; i < n; i++){
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
}
