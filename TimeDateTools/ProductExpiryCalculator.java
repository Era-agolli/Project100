package TimeDateTools;

import utils.InputHelper;

import java.time.LocalDate;
import java.util.Scanner;

public class ProductExpiryCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Product Expiry Calculator ---");

        int year = InputHelper.readInt(scanner, "Enter manufacturing year: ");
        int month = InputHelper.readInt(scanner, "Enter manufacturing month (1-12): ");
        int day = InputHelper.readInt(scanner, "Enter manufacturing day (1-31): ");
        int shelfLifeDays = InputHelper.readInt(scanner, "Enter shelf life in days: ");

        LocalDate mfgDate = LocalDate.of(year, month, day);
        LocalDate expiryDate = mfgDate.plusDays(shelfLifeDays);

        System.out.println("Product expiry date: " + expiryDate);
    }
}
