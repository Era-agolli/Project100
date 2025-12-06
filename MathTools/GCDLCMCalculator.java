package MathTools;

import utils.InputHelper;

import java.util.Scanner;

public class GCDLCMCalculator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- GCD & LCM Calculator ---");

        int a = InputHelper.readInt(scanner, "Enter the first number: ");
        int b = InputHelper.readInt(scanner, "Enter the second number: ");

        int gcd = gcd(a, b);
        long lcm = ((long) a * (long) b) / gcd;
        lcm = Math.abs(lcm);

        System.out.println("The greatest common divisor is : " + gcd);
        System.out.println("The least common multiple is : " + lcm);

    }
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
}
   }