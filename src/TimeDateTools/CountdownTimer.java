package TimeDateTools;

import utils.InputHelper;

import java.util.Scanner;

public class CountdownTimer {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Countdown Timer ---");

        int seconds = InputHelper.readInt(scanner, "Enter countdown time in seconds: ");

        try {
            for (int i = seconds; i >= 0; i--) {
                System.out.print("\rTime left: " + i + "s");
                Thread.sleep(1000);
            }
            System.out.println("\nTime's up!");
        } catch (InterruptedException e) {
            System.out.println("\nCountdown interrupted.");
        }
    }
}
