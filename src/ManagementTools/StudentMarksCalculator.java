package ManagementTools;

import utils.InputHelper;

import java.util.Scanner;

public class StudentMarksCalculator {

    public void run() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Student Marks Calculator ---");

        String studentName = InputHelper.readString(scanner,"Enter student name: ");
        int subjects = InputHelper.readInt(scanner,"Enter number of subjects: ");

        double total = 0;

        for (int i = 1; i <= subjects; i++) {
            double mark = InputHelper.readDouble(scanner,"Enter mark for subject " + i + ": ");
            total += mark;
        }

        double average = total / subjects;

        String grade;
        if (average >= 90) grade = "A";
        else if (average >= 80) grade = "B";
        else if (average >= 70) grade = "C";
        else if (average >= 60) grade = "D";
        else grade = "F";

        System.out.println("\n--- Result ---");
        System.out.println("Student: " + studentName);
        System.out.println("Total Marks: " + total);
        System.out.println("Average: " + average);
        System.out.println("Final Grade: " + grade);
    }
}
