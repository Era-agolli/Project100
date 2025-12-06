package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class ScientificCalculator {

    public void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Scientific Calculator ---");

        double x = InputHelper.readDouble(scanner,"Enter a number: ");
        System.out.println("Choose between these function:  1.Sin  2.Cos  3.Tan  4.Log  5.Sqrt");
        int choice = InputHelper.readInt(scanner,"Enter your  choice between 1-5 : ");

        double result = switch (choice){
            case 1 -> Math.sin(Math.toRadians(x));
            case 2 -> Math.cos(Math.toRadians(x));
            case 3 -> Math.tan(Math.toRadians(x));
            case 4 -> Math.log(x);
            case 5 -> Math.sqrt(x);
            default -> {
                System.out.println("Invalid choice");
                yield 0;
            }
        };
        System.out.println("The Result is : " + result);
    }
}

