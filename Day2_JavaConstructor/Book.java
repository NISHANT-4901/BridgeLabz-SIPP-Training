package Day2_JavaConstructor;

public class Book {
    // Attributes
    private String title;
    private String author;
    private int price;

    // Default Constructor
    public Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0;
    }

    // Parameterized Constructor
    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : " + price);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Using default constructor
        Book defaultBook = new Book();
        System.out.println("Using Default Constructor:");
        defaultBook.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Book customBook = new Book("Atomic Habits", "James Clear", 499);
        System.out.println("Using Parameterized Constructor:");
        customBook.displayDetails();
    }
}
