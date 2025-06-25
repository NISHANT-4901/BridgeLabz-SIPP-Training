import java.util.ArrayList;
import java.util.Scanner;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    double getTotalCost() {
        return price * quantity;
    }

    void displayItem() {
        System.out.println(
                itemName + " | Price: ₹" + price + " | Quantity: " + quantity + " | Total: ₹" + getTotalCost());
    }
}

public class ShoppingCart {
    static ArrayList<CartItem> cart = new ArrayList<>();

    static void addItem(String name, double price, int quantity) {
        cart.add(new CartItem(name, price, quantity));
        System.out.println("Item added to cart.");
    }

    static void removeItem(String name) {
        boolean found = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                found = true;
                System.out.println("Item removed from cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found in cart.");
        }
    }

    static void displayTotalCost() {
        double total = 0;
        System.out.println("\nCart Items:");
        for (CartItem item : cart) {
            item.displayItem();
            total += item.getTotalCost();
        }
        System.out.println("Total Cart Cost: ₹" + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Item\n2. Remove Item\n3. Display Cart\n4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    addItem(name, price, qty);
                    break;

                case 2:
                    System.out.print("Enter item name to remove: ");
                    String removeName = sc.nextLine();
                    removeItem(removeName);
                    break;

                case 3:
                    displayTotalCost();
                    break;

                case 4:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
