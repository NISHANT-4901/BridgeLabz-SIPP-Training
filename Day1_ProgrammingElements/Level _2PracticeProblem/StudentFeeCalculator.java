package Day1_ProgrammingElements;

import java.util.Scanner;

public class StudentFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take fee input
        System.out.print("Enter the course fee (INR): ");
        double fee = sc.nextDouble();

        // Take discount percentage input
        System.out.print("Enter the discount percentage: ");
        double discountPercent = sc.nextDouble();

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100.0;

        // Calculate final discounted fee
        double finalFee = fee - discount;

        // Output
        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);

        sc.close();
    }
}
