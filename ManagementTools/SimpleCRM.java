package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleCRM {

    static class Customer {
        String name;
        String email;
        String phone;

        Customer(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Simple CRM ---");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Exit");


            int choice = InputHelper.readInt(scanner,"Choose an option: ");

            switch (choice) {

                case 1:
                    String name = InputHelper.readString(scanner,"Enter customer name: ");
                    String email = InputHelper.readString(scanner,"Enter customer email: ");
                    String phone = InputHelper.readString(scanner,"Enter customer phone: ");
                    customers.add(new Customer(name, email, phone));
                    System.out.println("Customer added!");
                    break;

                case 2:
                    System.out.println("\n--- Customer List ---");
                    if (customers.isEmpty()) {
                        System.out.println("No customers added yet.");
                    } else {
                        for (Customer c : customers) {
                            System.out.println("Name: " + c.name +
                                    ", Email: " + c.email +
                                    ", Phone: " + c.phone);
                        }
                    }
                    break;

                case 3:
                    String search = InputHelper.readString(scanner,"Enter name to search: ");
                    boolean found = false;

                    for (Customer c : customers) {
                        if (c.name.equalsIgnoreCase(search)) {
                            System.out.println("Customer found!");
                            System.out.println("Name: " + c.name +
                                    ", Email: " + c.email +
                                    ", Phone: " + c.phone);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No customer with that name.");
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
