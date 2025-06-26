package Day2_JavaConstructor;

class Book {
    public String ISBN; // Public: accessible anywhere
    protected String title; // Protected: accessible in subclasses and same package
    private String author; // Private: accessible only within this class

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get author
    public String getAuthor() {
        return this.author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Subclass to access protected and public members
class EBook extends Book {
    private String downloadLink;

    public EBook(String ISBN, String title, String author, String downloadLink) {
        super(ISBN, title, author);
        this.downloadLink = downloadLink;
    }

    public void displayEBookDetails() {
        System.out.println("EBook ISBN: " + ISBN); // Accessing public member
        System.out.println("EBook Title: " + title); // Accessing protected member
        System.out.println("Download Link: " + downloadLink);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        book1.displayBookInfo();

        System.out.println("\n--- Updating Author ---");
        book1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + book1.getAuthor());

        System.out.println();

        EBook ebook = new EBook("978-1492078005", "Java: The Complete Reference", "Herbert Schildt",
                "http://ebook.link/java");
        ebook.displayEBookDetails();
    }
}
