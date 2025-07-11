package Day1_LinkedList;

import java.util.Scanner;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

public class InventoryManager {
    Item head = null;

    public void addAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos <= 0)
            return;
        if (pos == 1) {
            addAtBeginning(name, id, quantity, price);
            return;
        }
        Item temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null)
            return;
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int id) {
        if (head == null)
            return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    public void updateQuantityById(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
    }

    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                System.out.println(temp.name + " " + temp.id + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equals(name)) {
                System.out.println(temp.name + " " + temp.id + " " + temp.quantity + " " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    public Item mergeSort(Item head, String by, boolean ascending) {
        if (head == null || head.next == null)
            return head;
        Item mid = getMiddle(head);
        Item nextToMid = mid.next;
        mid.next = null;
        Item left = mergeSort(head, by, ascending);
        Item right = mergeSort(nextToMid, by, ascending);
        return merge(left, right, by, ascending);
    }

    public Item merge(Item a, Item b, String by, boolean ascending) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        Item result;
        boolean condition;
        if (by.equals("name")) {
            condition = ascending ? a.name.compareTo(b.name) <= 0 : a.name.compareTo(b.name) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }
        if (condition) {
            result = a;
            result.next = merge(a.next, b, by, ascending);
        } else {
            result = b;
            result.next = merge(a, b.next, by, ascending);
        }
        return result;
    }

    public Item getMiddle(Item head) {
        if (head == null)
            return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void sort(String by, boolean ascending) {
        head = mergeSort(head, by, ascending);
    }

    public void displayAll() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.name + " " + temp.id + " " + temp.quantity + " " + temp.price);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Add at beginning\n2.Add at end\n3.Add at position\n4.Remove by ID\n5.Update quantity\n6.Search by ID\n7.Search by name\n8.Total value\n9.Sort\n10.Display all\n11.Exit");
            int ch = sc.nextInt();
            if (ch == 11)
                break;
            switch (ch) {
                case 1:
                    manager.addAtBeginning(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 2:
                    manager.addAtEnd(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 3:
                    manager.addAtPosition(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
                    break;
                case 4:
                    manager.removeById(sc.nextInt());
                    break;
                case 5:
                    manager.updateQuantityById(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    manager.searchById(sc.nextInt());
                    break;
                case 7:
                    manager.searchByName(sc.next());
                    break;
                case 8:
                    manager.calculateTotalValue();
                    break;
                case 9:
                    String by = sc.next();
                    boolean asc = sc.next().equals("asc");
                    manager.sort(by, asc);
                    break;
                case 10:
                    manager.displayAll();
                    break;
            }
        }
        sc.close();
    }
}
