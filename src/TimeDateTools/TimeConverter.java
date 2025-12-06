package TimeDateTools;

import utils.InputHelper;

import java.util.Scanner;

public class TimeConverter {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Time Converter ---");

        int hours = InputHelper.readInt(scanner, "Enter hours: ");
        int minutes = InputHelper.readInt(scanner, "Enter minutes: ");
        int seconds = InputHelper.readInt(scanner, "Enter seconds: ");

        int totalSeconds = hours * 3600 + minutes * 60 + seconds;
        int totalMinutes = totalSeconds / 60;

        System.out.println("Total seconds: " + totalSeconds);
        System.out.println("Total minutes: " + totalMinutes);
    }
}
