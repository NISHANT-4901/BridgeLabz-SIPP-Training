package Day6_EncapPolymorInterAbst;

import java.util.*;

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);

    boolean checkAvailability();
}

// Abstract class representing a library item
abstract class LibraryItem implements Reservable {
    private String itemId;
    private String title;
    private String author;
    private boolean isReserved;
    private String borrower;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
        this.borrower = null;
    }

    public abstract int getLoanDuration();

    public String getItemDetails() {
        return "Item ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            this.borrower = borrowerName;
            this.isReserved = true;
            System.out.println(title + " has been reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    public boolean checkAvailability() {
        return !isReserved;
    }

    // Encapsulation: Getter for borrower (no public setter to protect data)
    public String getBorrower() {
        return borrower;
    }

    public boolean isReserved() {
        return isReserved;
    }
}

// Subclass: Book
class Book extends LibraryItem {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // days
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // days
    }
}

// Subclass: DVD
class DVD extends LibraryItem {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // days
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();

        libraryItems.add(new Book("B001", "The Alchemist", "Paulo Coelho"));
        libraryItems.add(new Magazine("M001", "National Geographic", "Various"));
        libraryItems.add(new DVD("D001", "Inception", "Christopher Nolan"));

        for (LibraryItem item : libraryItems) {
            System.out.println("\n" + item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item.checkAvailability()) {
                item.reserveItem("Alice");
            } else {
                System.out.println("Already reserved by: " + item.getBorrower());
            }

            System.out.println("Is Available: " + item.checkAvailability());
        }
    }
}
