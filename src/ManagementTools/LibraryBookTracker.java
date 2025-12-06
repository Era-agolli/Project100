package ManagementTools;

import utils.InputHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryBookTracker {

    static class Book {
        String title;
        String author;
        boolean borrowed;

        Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.borrowed = false;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.println("\n--- Library Book Tracker ---");

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            int choice = InputHelper.readInt(scanner,"");

            switch (choice) {
                case 1 -> {
                    String title = InputHelper.readString(scanner, "Book title: ");
                    String author = InputHelper.readString(scanner, "Author: ");
                    books.add(new Book(title, author));
                    System.out.println("Book added.");
                }
                case 2 -> {
                    System.out.println("\n--- Books ---");
                    if (books.isEmpty()) System.out.println("No books.");
                    else {
                        for (int i = 0; i < books.size(); i++) {
                            Book b = books.get(i);
                            System.out.println((i + 1) + ". " + b.title + " by " + b.author + " | " + (b.borrowed ? "Borrowed" : "Available"));
                        }
                    }
                }
                case 3 -> {
                    int idx = InputHelper.readInt(scanner, "Book number to borrow: ");
                    if (idx < 1 || idx > books.size()) System.out.println("Invalid.");
                    else if (books.get(idx - 1).borrowed) System.out.println("Already borrowed.");
                    else {
                        books.get(idx - 1).borrowed = true;
                        System.out.println("Book borrowed.");
                    }
                }
                case 4 -> {
                    int idx = InputHelper.readInt(scanner, "Book number to return: ");
                    if (idx < 1 || idx > books.size()) System.out.println("Invalid.");
                    else if (!books.get(idx - 1).borrowed) System.out.println("Book is not borrowed.");
                    else {
                        books.get(idx - 1).borrowed = false;
                        System.out.println("Book returned.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting Library Tracker...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
