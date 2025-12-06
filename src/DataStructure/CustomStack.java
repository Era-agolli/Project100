package DataStructure;

import utils.InputHelper;

import java.util.Scanner;

public class CustomStack {

    private int[] stack;
    private int top;

    public CustomStack(){
        stack = new int[10];  // initial size
        top = -1;
    }

    // Resize array when needed
    private void resize(){
        int newSize = stack.length * 2;
        int[] newStack = new int[newSize];

        for (int i = 0; i <= top; i++){
            newStack[i] = stack[i];
        }

        stack = newStack;
    }

    // Push
    public void push(int value){
        if (top == stack.length - 1){
            resize();
        }
        stack[++top] = value;
    }

    // Pop
    public Integer pop(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top--];
    }

    // Peek
    public Integer peek(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top];
    }

    // Empty check
    public boolean isEmpty(){
        return top == -1;
    }

    // Display
    public void display(){
        if (isEmpty()){
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (top -> bottom): ");
        for (int i = top; i >= 0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Interactive menu
    public void run(){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\n--- Custom Stack ---");
            System.out.println("1. Push an element onto the stack.");
            System.out.println("2. Pop an element from the stack.");
            System.out.println("3. View the top element.");
            System.out.println("4. Check if the stack  is empty.");
            System.out.println("5. Display all elements in the stack.");
            System.out.println("0. Exit.");
            System.out.print("Choose your option between 0-5: ");

            int choice = InputHelper.readInt(scanner,"");

            switch (choice){

                case 1 -> {
                    int value = InputHelper.readInt(scanner, "Enter the element you want to add: ");
                    push(value);
                    System.out.println("The element is pushed to the stack");
                }

                case 2 -> {
                    Integer popped = pop();
                    if (popped != null)
                        System.out.println("The element popped is: " + popped);
                }

                case 3 -> {
                    Integer topVal = peek();
                    if (topVal != null)
                        System.out.println("Top is: " + topVal);
                }

                case 4 ->
                        System.out.println(isEmpty() ? "Stack is empty." : "Stack is NOT empty.");

                case 5 -> display();

                case 0 -> {
                    System.out.println("Exiting Stack...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}


