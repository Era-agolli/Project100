package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class FactorialCalculator {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Factorial Calculator ---");

        int n = InputHelper.readInt(scanner, "Enter a number: ");

        if (n < 0){
            System.out.println("Factorial is not defined for negative numbers. ");
            return;
        }

        long factorial = 1;
        for (int i = 2; i <= n; i++){
            factorial *= i;
        }
            System.out.println("The Factorial is : " + factorial);
        }
    }

