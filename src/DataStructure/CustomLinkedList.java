package DataStructure;

import utils.InputHelper;

import java.util.Scanner;

public class CustomLinkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data){
            this.data = data;
        }
    }

    // Head of the linked list
    private Node head;

    // Add at end
    public void add(int value){
        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at index
    public void insertAt(int index, int value){
        if (index < 0){
            System.out.println("Invalid index.");
            return;
        }

        Node newNode = new Node(value);

        if (index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++){
            if (current == null){
                System.out.println("Index out of bounds.");
                return;
            }
            current = current.next;
        }

        if (current == null){
            System.out.println("Index out of bounds.");
            return;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Delete first occurrence of value
    public void delete(int value){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }

        if (head.data == value){
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != value){
            current = current.next;
        }

        if (current.next == null){
            System.out.println("Value not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Search
    public boolean search(int value){
        Node current = head;
        while (current != null){
            if (current.data == value) return true;
            current = current.next;
        }
        return false;
    }

    // Display list
    public void display(){
        if (head == null){
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.print("List: ");
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Interactive menu
    public void run(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n--- Custom Linked List ---");
            System.out.println("1. Add an element to the list.");
            System.out.println("2. Insert an element at a specific index.");
            System.out.println("3. Delete an element from the list.");
            System.out.println("4. Search for an element in the list.");
            System.out.println("5. Display all elements in the list.");
            System.out.println("0. Exit.");
            System.out.print("Choose your option between 0-5: ");

            int choice = InputHelper.readInt(scanner,"");

            switch (choice){

                case 1 -> {
                    int value = InputHelper.readInt(scanner, "Enter the element you want to add: ");
                    add(value);
                    System.out.println("The element is added successfully to the list");
                }

                case 2 -> {
                    int index = InputHelper.readInt(scanner, "Enter the index where you want to insert : ");
                    int value = InputHelper.readInt(scanner, "Enter the element to insert: ");
                    insertAt(index, value);
                    System.out.println("The element " + value + " is inserted at the index " + index);
                }

                case 3 -> {
                    int value = InputHelper.readInt(scanner, "Enter the element you want to delete: ");
                    delete(value);
                    System.out.println("The element is deleted successfully.");
                }

                case 4 -> {
                    int value = InputHelper.readInt(scanner, "Enter the  element you want to search: ");
                    System.out.println(search(value) ? "Element Found!" : "Element Not found.");
                }

                case 5 -> display();

                case 0 -> {
                    System.out.println("Exiting Linked List...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

