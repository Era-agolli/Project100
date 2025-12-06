package DataStructure;

import utils.InputHelper;

import java.util.Scanner;

public class CustomQueue {

    private static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private Node front; // head of queue
    private Node rear;  // tail of queue

    // Enqueue
    public void enqueue(int value){
        Node newNode = new Node(value);

        if (rear == null){
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue
    public Integer dequeue(){
        if (front == null){
            System.out.println("Queue is empty.");
            return null;
        }

        int value = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        return value;
    }

    // Peek
    public Integer peek(){
        if (front == null){
            System.out.println("Queue is empty.");
            return null;
        }
        return front.data;
    }

    // Check empty
    public boolean isEmpty(){
        return front == null;
    }

    // Display
    public void display(){
        if (front == null){
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;
        System.out.print("Queue: ");
        while (current != null){
            System.out.print(current.data + " <- ");
            current = current.next;
        }
        System.out.println("END");
    }

    // Interactive Menu
    public void run(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n--- Custom Queue ---");
            System.out.println("1. Enqueue an element into the queue.");
            System.out.println("2. Dequeue an element from the queue.");
            System.out.println("3. View the front element.");
            System.out.println("4. Check if the queue is empty.");
            System.out.println("5. Display all elements in th queue.");
            System.out.println("0. Exit.");
            System.out.print("Choose your option between 0-5: ");

            int choice = InputHelper.readInt(scanner,"");

            switch (choice){

                case 1 -> {
                    int value = InputHelper.readInt(scanner, "Enter the element you want to add: ");
                    enqueue(value);
                    System.out.println("The element is enqueued into the queue");
                }

                case 2 -> {
                    Integer removed = dequeue();
                    if (removed != null)
                        System.out.println("The element dequeued is: " + removed);
                }

                case 3 -> {
                    Integer top = peek();
                    if (top != null)
                        System.out.println("Front is: " + top);
                }

                case 4 ->
                        System.out.println(isEmpty() ? "Queue is empty." : "Queue is not empty.");

                case 5 -> display();

                case 0 -> {
                    System.out.println("Exiting Queue...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}

