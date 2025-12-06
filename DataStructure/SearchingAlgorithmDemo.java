package DataStructure;

import utils.InputHelper;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;

public class SearchingAlgorithmDemo {

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Searching Algorithm Demo ---");
            System.out.println("1. Linear Search.");
            System.out.println("2. Binary Search.");
            System.out.println("3. AVL Tree Search.");
            System.out.println("0. Exit.");

            int choice = InputHelper.readInt(scanner, "Choose search algorithm: ");

            if (choice == 0) break;

            switch (choice) {
                case 1 -> linearSearchDemo(scanner);
                case 2 -> binarySearchDemo(scanner);
                case 3 -> avlSearchDemo(scanner);
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // 1. Linear Search Demo
    private void linearSearchDemo(Scanner scanner) {
        int n = InputHelper.readInt(scanner, "Enter number of elements in the array: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = InputHelper.readInt(scanner, "Enter element " + (i + 1) + ": ");

        int key = InputHelper.readInt(scanner, "Enter element to search: ");
        int index = linearSearch(array, key);
        System.out.println(index != -1 ? "Element found at index " + index : "Element not found!");
    }

    private int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) if (arr[i] == key) return i;
        return -1;
    }

    // 2. Binary Search Demo
    private void binarySearchDemo(Scanner scanner) {
        int n = InputHelper.readInt(scanner, "Enter number of elements in the array: ");
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = InputHelper.readInt(scanner, "Enter element " + (i + 1) + ": ");

        Arrays.sort(array);
        System.out.println("Sorted Array: " + Arrays.toString(array));
        int key = InputHelper.readInt(scanner, "Enter element to search: ");
        int index = binarySearch(array, key);
        System.out.println(index != -1 ? "Element found at index " + index : "Element not found!");
    }

    private int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // 4. AVL Search Demo
    private void avlSearchDemo(Scanner scanner) {
        AVLTree avl = new AVLTree();
        int n = InputHelper.readInt(scanner, "Enter number of elements to insert in AVL Tree: ");
        for (int i = 0; i < n; i++) avl.insert(InputHelper.readInt(scanner, "Enter element " + (i + 1) + ": "));

        int key = InputHelper.readInt(scanner, "Enter element to search in AVL Tree: ");
        System.out.println(avl.search(key) ? "Element found!" : "Element not found!");
    }

    // AVL Tree Implementation
    class AVLTree {
        class Node {
            int key, height;
            Node left, right;
            Node(int key) { this.key = key; height = 1; }
        }
        Node root;
        int height(Node node) { return node == null ? 0 : node.height; }
        int balance(Node node) { return node == null ? 0 : height(node.left) - height(node.right); }
        Node rightRotate(Node y) {
            Node x = y.left; Node T2 = x.right;
            x.right = y; y.left = T2;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            return x;
        }
        Node leftRotate(Node x) {
            Node y = x.right; Node T2 = y.left;
            y.left = x; x.right = T2;
            x.height = Math.max(height(x.left), height(x.right)) + 1;
            y.height = Math.max(height(y.left), height(y.right)) + 1;
            return y;
        }
        void insert(int key) { root = insertRec(root, key); }
        Node insertRec(Node node, int key) {
            if (node == null) return new Node(key);
            if (key < node.key) node.left = insertRec(node.left, key);
            else if (key > node.key) node.right = insertRec(node.right, key);
            else return node;

            node.height = 1 + Math.max(height(node.left), height(node.right));
            int balance = balance(node);

            // Left Left Case
            if (balance > 1 && key < node.left.key) return rightRotate(node);
            // Right Right Case
            if (balance < -1 && key > node.right.key) return leftRotate(node);
            // Left Right Case
            if (balance > 1 && key > node.left.key) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            // Right Left Case
            if (balance < -1 && key < node.right.key) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
            return node;
        }
        boolean search(int key) { return searchRec(root, key); }
        boolean searchRec(Node node, int key) {
            if (node == null) return false;
            if (node.key == key) return true;
            return key < node.key ? searchRec(node.left, key) : searchRec(node.right, key);
        }
    }
}
