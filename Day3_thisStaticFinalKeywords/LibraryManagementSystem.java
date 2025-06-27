package Day3_thisStaticFinalKeywords;

public class LibraryManagementSystem {

    static class Book {
        // Static variable shared across all books
        static String libraryName = "City Central Library";

        // Final variable: ISBN should never change
        final String isbn;

        // Instance variables
        String title;
        String author;

        // Constructor using 'this' to resolve ambiguity
        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn; // final variable initialized once
        }

        // Static method to display the library name
        static void displayLibraryName() {
            System.out.println("Library: " + libraryName);
        }

        // Method to display book details
        void displayDetails() {
            if (this instanceof Book) {
                System.out.println("Book Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("ISBN: " + isbn);
            }
        }
    }

    public static void main(String[] args) {
        // Display library name using static method
        Book.displayLibraryName();

        // Create book objects
        Book book1 = new Book("1984", "George Orwell", "ISBN001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "ISBN002");

        // Display details
        System.out.println("\nBook 1 Details:");
        book1.displayDetails();

        System.out.println("\nBook 2 Details:");
        book2.displayDetails();
    }
}
