package TimeDateTools;

import utils.InputHelper;

import java.time.LocalTime;
import java.util.Scanner;

public class SimpleAlarmLogic {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Simple Alarm Logic ---");

        int hour = InputHelper.readInt(scanner, "Set alarm hour (0-23): ");
        int minute = InputHelper.readInt(scanner, "Set alarm minute (0-59): ");

        LocalTime alarmTime = LocalTime.of(hour, minute);

        System.out.println("Alarm set for: " + alarmTime);

        while (true) {
            LocalTime now = LocalTime.now();
            if (now.getHour() == alarmTime.getHour() && now.getMinute() == alarmTime.getMinute()) {
                System.out.println("ALARM! Time is: " + alarmTime);
                break;
            }
            try {
                Thread.sleep(1000); // check every second
            } catch (InterruptedException e) {
                System.out.println("Alarm interrupted.");
                break;
            }
        }
    }
}
