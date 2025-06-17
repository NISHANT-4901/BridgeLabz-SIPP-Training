package Day4_Methods;

import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input
        System.out.print("Enter total number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter total number of children: ");
        int numberOfChildren = scanner.nextInt();

        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than zero.");
            return;
        }

        // Step 2: Call method
        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        // Step 3: Display result
        System.out.println("Each child gets: " + result[0] + " chocolate(s)");
        System.out.println("Remaining chocolates: " + result[1]);
    }

    // Step 2: Method to calculate quotient and remainder
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int quotient = number / divisor;
        int remainder = number % divisor;
        return new int[] { quotient, remainder };
    }
}
