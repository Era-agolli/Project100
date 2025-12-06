package TimeDateTools;

import utils.InputHelper;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeInMonthsDaysCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Age in Months & Days Calculator ---");

        int year = InputHelper.readInt(scanner, "Enter birth year: ");
        int month = InputHelper.readInt(scanner, "Enter birth month (1-12): ");
        int day = InputHelper.readInt(scanner, "Enter birth day (1-31): ");

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

        Period period = Period.between(birthDate, now);

        int totalMonths = period.getYears() * 12 + period.getMonths();
        int totalDays = (int) java.time.temporal.ChronoUnit.DAYS.between(birthDate, now);

        System.out.println("Age: " + period.getYears() + " years, " +
                period.getMonths() + " months, " + period.getDays() + " days");
        System.out.println("Total months: " + totalMonths);
        System.out.println("Total days: " + totalDays);
    }
}

