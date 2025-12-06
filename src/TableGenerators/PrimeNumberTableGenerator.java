package TableGenerators;

import utils.InputHelper;

import java.util.Scanner;

public class PrimeNumberTableGenerator {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Prime Number Table Generator ---");

        int limit = InputHelper.readInt(scanner, "Generate primes up to: ");

        System.out.println("\nPrime numbers:");
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

