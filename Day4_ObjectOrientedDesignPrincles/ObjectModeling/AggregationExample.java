package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.ArrayList;

class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayDetails() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    String name;
    ArrayList<Book> books;

    Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    void showLibraryBooks() {
        System.out.println("Books in " + name + " Library:");
        for (Book b : books) {
            b.displayDetails();
        }
        System.out.println();
    }
}

public class AggregationExample {
    public static void main(String[] args) {
        // Books created independently of any library
        Book book1 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("The Alchemist", "Paulo Coelho");

        // Libraries
        Library centralLibrary = new Library("Central");
        Library communityLibrary = new Library("Community");

        // Aggregation: books are added to libraries
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        communityLibrary.addBook(book2); // same book in another library
        communityLibrary.addBook(book3);

        // Display
        centralLibrary.showLibraryBooks();
        communityLibrary.showLibraryBooks();
    }
}
