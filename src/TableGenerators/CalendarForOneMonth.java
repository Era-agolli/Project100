package TableGenerators;

import utils.InputHelper;

import java.time.LocalDate;
import java.util.Scanner;

public class CalendarForOneMonth {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- One-Month Calendar ---");

        int year = InputHelper.readInt(scanner,"Enter year: ");
        int month = InputHelper.readInt(scanner,"Enter month (1–12): ");

        LocalDate date = LocalDate.of(year, month, 1);
        int daysInMonth = date.lengthOfMonth();
        int startDay = date.getDayOfWeek().getValue(); // 1 = Monday, 7 = Sunday

        System.out.println("\nMon Tue Wed Thu Fri Sat Sun");

        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }

        int dayOfWeek = startDay;

        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            if (dayOfWeek == 7) {
                System.out.println();
                dayOfWeek = 1;
            } else {
                dayOfWeek++;
            }
        }

        System.out.println();
    }
}
