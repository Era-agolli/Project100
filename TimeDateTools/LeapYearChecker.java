package TimeDateTools;

import utils.InputHelper;

import java.util.Scanner;

public class LeapYearChecker {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Leap Year Checker ---");

        int year = InputHelper.readInt(scanner, "Enter year: ");

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (isLeap) {
            System.out.println(year + " is a leap year.");
        } else {
            System.out.println(year + " is NOT a leap year.");
        }
    }
}
