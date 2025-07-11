package Day1_LinkedList;

import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean available;
    Book next, prev;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

public class LibraryManager {
    Book head = null, tail = null;

    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {
        if (pos <= 0)
            return;
        if (pos == 1) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            addAtEnd(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        newBook.next = temp.next;
        newBook.prev = temp;
        temp.next.prev = newBook;
        temp.next = newBook;
    }

    public void removeById(int id) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                if (temp == head) {
                    head = temp.next;
                    if (head != null)
                        head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    if (tail != null)
                        tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.id + " "
                        + (temp.available ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    public void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.id + " "
                        + (temp.available ? "Available" : "Not Available"));
            }
            temp = temp.next;
        }
    }

    public void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.available = status;
                return;
            }
            temp = temp.next;
        }
    }

    public void displayForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.id + " "
                    + (temp.available ? "Available" : "Not Available"));
            temp = temp.next;
        }
    }

    public void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.author + " " + temp.genre + " " + temp.id + " "
                    + (temp.available ? "Available" : "Not Available"));
            temp = temp.prev;
        }
    }

    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total Books: " + count);
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Add at beginning\n2.Add at end\n3.Add at position\n4.Remove by ID\n5.Search by title\n6.Search by author\n7.Update availability\n8.Display forward\n9.Display reverse\n10.Count books\n11.Exit");
            int ch = sc.nextInt();
            if (ch == 11)
                break;
            switch (ch) {
                case 1:
                    manager.addAtBeginning(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;
                case 2:
                    manager.addAtEnd(sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextBoolean());
                    break;
                case 3:
                    manager.addAtPosition(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
                            sc.nextBoolean());
                    break;
                case 4:
                    manager.removeById(sc.nextInt());
                    break;
                case 5:
                    manager.searchByTitle(sc.next());
                    break;
                case 6:
                    manager.searchByAuthor(sc.next());
                    break;
                case 7:
                    manager.updateAvailability(sc.nextInt(), sc.nextBoolean());
                    break;
                case 8:
                    manager.displayForward();
                    break;
                case 9:
                    manager.displayReverse();
                    break;
                case 10:
                    manager.countBooks();
                    break;
            }
        }
        sc.close();
    }
}
