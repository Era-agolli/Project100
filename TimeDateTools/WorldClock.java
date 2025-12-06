package TimeDateTools;

import utils.InputHelper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WorldClock {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- World Clock ---");

        String[] cities = {"UTC", "New_York", "London", "Tokyo", "Sydney"};
        System.out.println("Available cities:");
        for (String city : cities) System.out.println(city);

        String city = InputHelper.readString(scanner, "Enter city name: ");

        try {
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of(city.replace(" ", "_")));
            String time = zdt.format(DateTimeFormatter.ofPattern("HH:mm:ss, dd MMM yyyy"));
            System.out.println(city + " time: " + time);
        } catch (Exception e) {
            System.out.println("Invalid city name or timezone.");
        }
    }
}
