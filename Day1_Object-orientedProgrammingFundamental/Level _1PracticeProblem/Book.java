import java.util.Scanner;

class Book {
    String title;
    String author;
    double price;

    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void displayDetails() {
        System.out.println("Book Title : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Price      : " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Book book = new Book(title, author, price);
        System.out.println("\nBook Details:");
        book.displayDetails();

        sc.close();
    }
}
