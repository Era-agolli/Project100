package DataStructure;

import utils.InputHelper;

import java.util.Scanner;

public class PriorityQueueImplementation {

    private int[] heap;
    private int size;

    public PriorityQueueImplementation() {
        heap = new int[20];
        size = 0;
    }

    private void resize() {
        int[] newHeap = new int[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private void swap(int i, int j) {
        int tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public void insert(int value) {
        if (size == heap.length) resize();
        heap[size] = value;

        int current = size;
        size++;
        System.out.println("Element is added");

        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[current] < heap[parent]) {
                swap(current, parent);
                current = parent;
            } else break;
        }
    }

    public Integer remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return null;
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;

        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int smallest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;

        if (left < size && heap[left] < heap[smallest]) smallest = left;
        if (right < size && heap[right] < heap[smallest]) smallest = right;

        if (smallest != index) {
            swap(smallest, index);
            heapify(smallest);
        }
    }

    public Integer peek() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return null;
        }
        return heap[0];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty.");
            return;
        }
        System.out.print("Heap: ");
        for (int i = 0; i < size; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Priority Queue (Min-Heap) ---");
            System.out.println("1. Insert an element into the Heap.");
            System.out.println("2. Remove an element from the Heap.");
            System.out.println("3. View the top element of the Heap.");
            System.out.println("4. Display the Heap.");
            System.out.println("0. Exit.");
            System.out.print("Choose your option between 0-4: ");

            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {

                case 1 -> insert(InputHelper.readInt(scanner, "Enter element you want to add: "));
                case 2 -> {
                    Integer removed = remove();
                    if (removed != null) System.out.println("The element removed is: " + removed);
                }
                case 3 -> {
                    Integer top = peek();
                    if (top != null) System.out.println("The Top is: " + top);
                }
                case 4 -> display();
                case 0 -> { return; }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
