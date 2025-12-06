package TextTools;

import utils.InputHelper;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramChecker {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Anagram Checker ---");

        String first = InputHelper.readString(scanner, "Enter first word: ");
        String second = InputHelper.readString(scanner, "Enter second word: ");

        String clean1 = first.replaceAll("\\s+", "").toLowerCase();
        String clean2 = second.replaceAll("\\s+", "").toLowerCase();

        char[] arr1 = clean1.toCharArray();
        char[] arr2 = clean2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        boolean isAnagram = Arrays.equals(arr1, arr2);

        System.out.println(isAnagram ? "They ARE anagrams!" : "They are NOT anagrams.");
    }
}

