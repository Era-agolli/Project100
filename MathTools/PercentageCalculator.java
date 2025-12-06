package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class PercentageCalculator {

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Percentage Calculator ---");

        double totalMarks = InputHelper.readDouble(scanner, "Enter total marks: ");
        double obtainedMarks = InputHelper.readDouble(scanner, "Enter obtained marks: ");

        if (totalMarks == 0){
            System.out.println("Total cannot be zero");
            return;
        }

        double percentage = (obtainedMarks / totalMarks) * 100;
        System.out.println("The Percentage is : " + percentage + "%");
    }
}
