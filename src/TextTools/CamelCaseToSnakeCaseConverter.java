package TextTools;

import utils.InputHelper;

import java.util.Scanner;

public class CamelCaseToSnakeCaseConverter {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- CamelCase to SnakeCase Converter ---");

        String input = InputHelper.readString(scanner, "Enter camelCase text: ");

        String result = input
                .replaceAll("([a-z])([A-Z])", "$1_$2")
                .toLowerCase();

        System.out.println("snake_case: " + result);
    }
}

