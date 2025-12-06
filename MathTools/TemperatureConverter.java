package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class TemperatureConverter {

    public void run(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Temperature Converter ---");
        System.out.println("1.Convert from Celsius to Fahrenheit");
        System.out.println("2.Convert from Fahrenheit to Celsius");
        System.out.println("3.Convert from Celsius to Kelvin");
        System.out.println("4.Convert from Kelvin to Celsius");

       int choice = InputHelper.readInt(scanner,"Choose an option: ");
       double value = InputHelper.readDouble(scanner, "Enter the value : ");

        double result;

        switch (choice) {
            case 1 -> {
                result = (value * 9/5) + 32;
                System.out.println("The Temperature of " + value + " °C is converted in " + result + " °F");
            }
            case 2 -> {
                result = (value - 32) * 5/9;
                System.out.println("The Temperature of "+ value + " °F is converted in  " + result + " °C");
            }
            case 3 -> {
                result = value + 273.15;
                System.out.println("the Temperature of " + value + " °C is converted in " + result + " K");
            }
            case 4 -> {
                result = value - 273.15;
                System.out.println("The Temperature of " + value + " °K is converted in  " + result + " °C");
            }
            default -> System.out.println("Invalid choice.");
        }
    }
}
