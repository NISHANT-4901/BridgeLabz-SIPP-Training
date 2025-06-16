import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number (positive integer): ");
        int n = sc.nextInt();
        sc.close();

        // Check if the number is a natural number
        if (n <= 0) {
            System.out.println("Invalid input. Please enter a positive natural number.");
            return;
        }

        // Compute sum using while loop
        int sumWhile = 0;
        int counter = 1;

        while (counter <= n) {
            sumWhile += counter;
            counter++;
        }

        // Compute sum using formula
        int sumFormula = n * (n + 1) / 2;

        // Display results
        System.out.println("Sum using while loop: " + sumWhile);
        System.out.println("Sum using formula: " + sumFormula);

        // Compare results
        if (sumWhile == sumFormula) {
            System.out.println("Both results are correct and match.");
        } else {
            System.out.println("There is a mismatch in the results.");
        }
    }
}
