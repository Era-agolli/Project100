package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class BasicCalculator {

    public void run(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Basic Calculator ---");

        double first = InputHelper.readDouble(scanner, "Enter the first number:");

        double second = InputHelper.readDouble(scanner, "Enter the second number ");

        char operation = InputHelper.readChar(scanner, "Choose between these operation (+, -, *, /): ");

        if (operation == '/' && second == 0){
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }

        double result = switch (operation){
            case '+' -> first + second;
            case  '-' -> first - second;
            case  '*' -> first * second;
            case  '/' -> first / second;
            default -> {
                System.out.println("Invalid operator");
                yield 0;
            }
        };

        System.out.println("The Result is : " + result);
    }
}
