package HealthTools;

import utils.InputHelper;

import java.util.Scanner;

public class BMICalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Body Mass Index (BMI) Calculator ---");

        double weight = InputHelper.readDouble(scanner, "Enter your weight (kg): ");
        double height = InputHelper.readDouble(scanner, "Enter your height (m):");

        if (height <= 0) {
            System.out.println("Error: Height must be greater than zero");
            return;
        }

        double bmi = weight / (height * height);

        System.out.println("Your BMI is: " + bmi);

        if (bmi < 18.5) {
            System.out.println("BMI Category: Underweight");
        } else if (bmi < 25) {
            System.out.println("BMI Category: Normal weight");
        } else if (bmi < 30) {
            System.out.println("BMI Category: Overweight");
        } else {
            System.out.println("BMI Category: Obese");
        }
    }
    }


