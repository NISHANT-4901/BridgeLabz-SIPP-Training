package Day1_LinkedList;

import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

public class TicketReservationSystem {
    Ticket head = null;
    Ticket tail = null;

    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
    }

    public void removeTicket(int id) {
        if (head == null)
            return;
        if (head == tail && head.ticketId == id) {
            head = tail = null;
            return;
        }
        if (head.ticketId == id) {
            head = head.next;
            tail.next = head;
            return;
        }
        Ticket temp = head;
        while (temp.next != head && temp.next.ticketId != id) {
            temp = temp.next;
        }
        if (temp.next.ticketId == id) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: "
                    + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomer(String name) {
        if (head == null)
            return;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: "
                        + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByMovie(String movie) {
        if (head == null)
            return;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("ID: " + temp.ticketId + " | Customer: " + temp.customerName + " | Movie: "
                        + temp.movieName + " | Seat: " + temp.seatNumber + " | Time: " + temp.bookingTime);
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void countTickets() {
        if (head == null) {
            System.out.println("Total Tickets: 0");
            return;
        }
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Tickets: " + count);
    }

    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Add Ticket\n2.Remove Ticket\n3.Display Tickets\n4.Search by Customer\n5.Search by Movie\n6.Count Tickets\n7.Exit");
            int ch = sc.nextInt();
            if (ch == 7)
                break;
            switch (ch) {
                case 1:
                    system.addTicket(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
                    break;
                case 2:
                    system.removeTicket(sc.nextInt());
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    system.searchByCustomer(sc.next());
                    break;
                case 5:
                    system.searchByMovie(sc.next());
                    break;
                case 6:
                    system.countTickets();
                    break;
            }
        }
        sc.close();
    }
}
