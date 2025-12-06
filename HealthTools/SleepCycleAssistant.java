package HealthTools;

import java.util.Scanner;
import utils.InputHelper;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SleepCycleAssistant {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Sleep Cycle Assistant (Bedtime Planner) ---\n");
        System.out.println("Enter your desired wake-up time, and we'll suggest optimal bedtimes based on 90-minute sleep cycles.\n");

        String wakeTimeInput = InputHelper.readString(scanner, "Enter your desired wake-up time (HH:MM, 24-hour format): ");

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime wakeTime = LocalTime.parse(wakeTimeInput, formatter);

            int cycleMinutes = 90;
            int fallAsleepMinutes = 15;

            System.out.println("\nTo wake up feeling refreshed, try going to bed at one of these times:");
            for (int i = 1; i <= 6; i++) { // up to 6 cycles
                LocalTime bedtime = wakeTime.minusMinutes(i * cycleMinutes + fallAsleepMinutes);
                System.out.println("- " + bedtime.format(formatter));
            }

            System.out.println("\nTips:");
            System.out.println("• Each sleep cycle is ~90 minutes.");
            System.out.println("• Allow ~15 minutes to fall asleep.");
            System.out.println("• Aim for 4-6 full cycles for optimal rest.\n");

        } catch (Exception e) {
            System.out.println("Invalid time format. Please use HH:MM in 24-hour format.");
        }
    }
}
