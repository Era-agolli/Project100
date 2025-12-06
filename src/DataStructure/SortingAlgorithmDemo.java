package DataStructure;

import utils.InputHelper;

import java.util.Scanner;
import java.util.*;

public class SortingAlgorithmDemo {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sorting Algorithm Demo ---");
            System.out.println("1. Bubble Sort.");
            System.out.println("2. Selection Sort.");
            System.out.println("3. Insertion Sort.");
            System.out.println("0. Exit.");

            int choice = InputHelper.readInt(scanner, "Choose a sorting algorithm: ");

            if (choice == 0) break;

            int n = InputHelper.readInt(scanner, "Enter number of elements in the array: ");
            int[] array = new int[n];
            for (int i = 0; i < n; i++)
                array[i] = InputHelper.readInt(scanner, "Enter element " + (i + 1) + ": ");

            switch (choice) {
                case 1 -> bubbleSort(array);
                case 2 -> selectionSort(array);
                case 3 -> insertionSort(array);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Bubble Sort with step-by-step display
    private void bubbleSort(int[] arr) {
        System.out.println("\n--- Bubble Sort ---");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                System.out.println("Step " + (i + 1) + "." + (j + 1) + ": " + Arrays.toString(arr));
            }
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Selection Sort with step-by-step display
    private void selectionSort(int[] arr) {
        System.out.println("\n--- Selection Sort ---");
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            System.out.println("Step " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    // Insertion Sort with step-by-step display
    private void insertionSort(int[] arr) {
        System.out.println("\n--- Insertion Sort ---");
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println("Step " + i + ": " + Arrays.toString(arr));
        }
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
