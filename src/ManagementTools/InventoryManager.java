package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryManager {

    static class Item {
        String name;
        int quantity;

        Item(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Item> inventory = new ArrayList<>();

        System.out.println("\n--- Inventory Manager ---");

        while (true) {
            System.out.println("\n1. Add Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Update Quantity");
            System.out.println("4. Remove Item");
            System.out.println("5. Exit");
            System.out.println("Choose on option:");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String name = InputHelper.readString(scanner, "Enter item name: ");
                    int qty = InputHelper.readInt(scanner, "Enter quantity: ");
                    inventory.add(new Item(name, qty));
                    System.out.println("Item added.");
                }
                case 2 -> {
                    System.out.println("\n--- Inventory ---");
                    if (inventory.isEmpty()) System.out.println("No items.");
                    else {
                        for (int i = 0; i < inventory.size(); i++) {
                            Item it = inventory.get(i);
                            System.out.println((i + 1) + ". " + it.name + " | Qty: " + it.quantity);
                        }
                    }
                }
                case 3 -> {
                    if (inventory.isEmpty()) {
                        System.out.println("No items to update.");
                        break;
                    }
                    int index = InputHelper.readInt(scanner, "Item number: ");
                    if (index < 1 || index > inventory.size()) {
                        System.out.println("Invalid.");
                        break;
                    }
                    int newQty = InputHelper.readInt(scanner, "New quantity: ");
                    inventory.get(index - 1).quantity = newQty;
                    System.out.println("Quantity updated.");
                }
                case 4 -> {
                    int rem = InputHelper.readInt(scanner, "Item number to remove: ");
                    if (rem < 1 || rem > inventory.size()) System.out.println("Invalid.");
                    else {
                        inventory.remove(rem - 1);
                        System.out.println("Item removed.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting Inventory Manager...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
