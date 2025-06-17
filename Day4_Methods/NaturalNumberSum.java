package Day4_Methods;

import java.util.Scanner;

public class NaturalNumberSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get user input
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive natural number.");
        } else {
            // Step 2: Call method to find sum
            int sum = findSumOfNaturalNumbers(n);
            System.out.println("The sum of first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }

    // Step 2: Method to find sum of natural numbers
    public static int findSumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
