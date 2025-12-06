package DataStructure;

import utils.InputHelper;

import java.util.LinkedList;
import java.util.Scanner;
    public class CustomHashMap<K, V> {

        // Entry class
        static class Entry<K, V> {
            K key;
            V value;
            Entry(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int SIZE = 16; // default capacity
        private LinkedList<Entry<K, V>>[] table;

        @SuppressWarnings("unchecked")
        public CustomHashMap() {
            table = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                table[i] = new LinkedList<>();
            }
        }

        private int hash(K key) {
            return (key == null ? 0 : key.hashCode()) % SIZE;
        }

        public void put(K key, V value) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = table[index];

            for (Entry<K, V> entry : bucket) {
                if (entry.key == null ? key == null : entry.key.equals(key)) {
                    entry.value = value; // update
                    return;
                }
            }

            bucket.add(new Entry<>(key, value)); // add new
        }

        public V get(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = table[index];

            for (Entry<K, V> entry : bucket) {
                if (entry.key == null ? key == null : entry.key.equals(key)) {
                    return entry.value;
                }
            }

            return null; // not found
        }

        public boolean containsKey(K key) {
            return get(key) != null;
        }

        public void remove(K key) {
            int index = hash(key);
            LinkedList<Entry<K, V>> bucket = table[index];

            bucket.removeIf(entry -> entry.key == null ? key == null : entry.key.equals(key));
        }

        public void display() {
            System.out.println("--- Custom HashMap Contents ---");
            for (int i = 0; i < SIZE; i++) {
                if (!table[i].isEmpty()) {
                    System.out.print("Bucket " + i + ": ");
                    for (Entry<K, V> entry : table[i]) {
                        System.out.print("[" + entry.key + "=" + entry.value + "] ");
                    }
                    System.out.println();
                }
            }
        }

        // --- Run method for console interaction ---
        public void run() {
            Scanner scanner = new Scanner(System.in);
            CustomHashMap<String, String> map = new CustomHashMap<>();

            while (true) {
                System.out.println("\n--- Custom HashMap ---");
                System.out.println("1. Add a key-value pair to the HashMap.");
                System.out.println("2. Search for a key and retrieve it's value.");
                System.out.println("3. Remove a key-value pair from the HashMap.");
                System.out.println("4. Check whether the HashMap contains a specific key.");
                System.out.println("5. Display all entries in the HashMap.");
                System.out.println("0. Exit.");

                int choice = InputHelper.readInt(scanner, "Choose your option between 0-5: ");

                switch (choice) {
                    case 1 -> {
                        String key = InputHelper.readString(scanner, "Enter the key you want to add: ");
                        String value = InputHelper.readString(scanner, "Enter the value you want the key to have: ");
                        map.put(key, value);
                        System.out.println("The Key-Value pair is added successfully.");
                    }
                    case 2 -> {
                        String key = InputHelper.readString(scanner, "Enter the key to search for the value: ");
                        String value = map.get(key);
                        if (value != null) System.out.println("The Value for this key is: " + value);
                        else System.out.println("Key cannot be found.");
                    }
                    case 3 -> {
                        String key = InputHelper.readString(scanner, "Enter the key you want to remove: ");
                        map.remove(key);
                        System.out.println("The key is removed successfully.");
                    }
                    case 4 -> {
                        String key = InputHelper.readString(scanner, "Enter the key you want to check: ");
                        System.out.println(map.containsKey(key) ? "Key exists!" : "Key does not exist.");
                    }
                    case 5 -> map.display();
                    case 0 -> {
                        System.out.println("Exiting Custom HashMap...");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }



