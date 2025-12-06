package DataStructure;

import utils.InputHelper;

import java.util.Scanner;

public class BinaryTreeImplementation {

    static class Node{
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BinaryTreeImplementation(){
        root = null;
    }

    public void insert(int data){
        root = insertRec(root,data);
    }

    private Node insertRec(Node root,int data){
        if (root == null){
            root = new Node(data);
            return root;
        }
        if (data < root.data)
            root.left = insertRec(root.left,data);
        else if (data > root.data)
            root.right = insertRec(root.right,data);
            return root;
        }

        public boolean search(int key){
        return searchRec(root,key);
        }

        private boolean searchRec(Node root,int key){
        if (root == null)
            return false;
        if (key == root.data)
            return true;
        return key < root.data ? searchRec(root.left,key) : searchRec(root.right,key);
        }

        public void inorder(){
        System.out.println("The Inorder Traversal is: ");
        inorderRec(root);
        System.out.println();

        }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal
    public void preorder() {
        System.out.print("The Preorder Traversal is: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal
    public void postorder() {
        System.out.print("The Postorder Traversal is: ");
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    // Delete a node
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return root;

        if (key < root.data)
            root.left = deleteRec(root.left, key);
        else if (key > root.data)
            root.right = deleteRec(root.right, key);
        else {
            // Node with one or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    // Run method for console interaction
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Binary Tree  ---");
            System.out.println("1. Insert an element into the Binary Tree.");
            System.out.println("2. Search for an element in the Binary Tree.");
            System.out.println("3. Delete an element from the Binary Tree.");
            System.out.println("4. Display the Inorder Traversal of the Binary Tree.");
            System.out.println("5. Display the Preorder Traversal of the Binary Tree.");
            System.out.println("6. Display the Postorder Traversal of the Binary Tree.");
            System.out.println("0. Exit.");

            int choice = InputHelper.readInt(scanner, "Choose your option between 0-6: ");

            switch (choice) {
                case 1 -> {
                    int val = InputHelper.readInt(scanner, "Enter the element you want to insert: ");
                    insert(val);
                    System.out.println("The element was added successfully.");
                }
                case 2 -> {
                    int val = InputHelper.readInt(scanner, "Enter the element you want to search: ");
                    boolean found = search(val);
                    System.out.println(found ? "Element found!" : "Element not found!");
                }
                case 3 -> {
                    int val = InputHelper.readInt(scanner, "Enter the element you want to delete: ");
                    delete(val);
                    System.out.println("The element was deleted successfully.");
                }
                case 4 -> inorder();
                case 5 -> preorder();
                case 6 -> postorder();
                case 0 -> {
                    System.out.println("Exiting Binary Tree...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}





