package Day1_ProgrammingElements;

import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: unit price and quantity
        System.out.print("Enter unit price (INR): ");
        double unitPrice = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        // Calculate total price
        double totalPrice = unitPrice * quantity;

        // Output the result
        System.out.println("The total purchase price is INR " + totalPrice +
                " if the quantity " + quantity +
                " and the unit price is INR " + unitPrice);

        sc.close();
    }
}
