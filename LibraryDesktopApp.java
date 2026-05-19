import java.util.*;

class Book {
    String id, title, author;
    int quantity;

    Book(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + " | " + title + " | " + author + " | Qty: " + quantity);
    }
}

public class LibraryDesktopApp {

    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: searchBook(); break;
                case 4: deleteBook(); break;
                case 5: System.out.println("Thank you!"); break;
                default: System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addBook() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();

        books.add(new Book(id, title, author, qty));
        System.out.println("✅ Book added!");
    }

    static void viewBooks() {
        for (Book b : books) {
            b.display();
        }
    }

    static void searchBook() {
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                return;
            }
        }
        System.out.println("Book not found!");
    }

    static void deleteBook() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        for (Book b : books) {
            if (b.id.equals(id)) {
                books.remove(b);
                System.out.println("✅ Deleted!");
                return;
            }
        }
        System.out.println("Book not found!");
    }
}