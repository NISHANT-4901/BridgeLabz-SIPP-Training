package Day2_JavaConstructor;

public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Constructor
    public LibraryBook(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Sorry, the book '" + title + "' is currently not available.");
        }
    }

    // Display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("Atomic Habits", "James Clear", 499.0, true);
        book1.displayDetails();

        System.out.println("\nTrying to borrow the book...");
        book1.borrowBook();

        System.out.println("\nTrying to borrow again...");
        book1.borrowBook();

        System.out.println("\nFinal Status:");
        book1.displayDetails();
    }
}
