package TimeDateTools;

import utils.InputHelper;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class DayOfWeekCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Day of Week Calculator ---");

        int year = InputHelper.readInt(scanner, "Enter year: ");
        int month = InputHelper.readInt(scanner, "Enter month (1-12): ");
        int day = InputHelper.readInt(scanner, "Enter day (1-31): ");

        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dow = date.getDayOfWeek();

        System.out.println("The day of the week is: " + dow);
    }
}
