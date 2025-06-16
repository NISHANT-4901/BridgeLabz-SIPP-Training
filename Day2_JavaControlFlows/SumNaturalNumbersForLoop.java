import java.util.Scanner;

public class SumNaturalNumbersForLoop {
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

        // Compute sum using for loop
        int sumFor = 0;
        for (int i = 1; i <= n; i++) {
            sumFor += i;
        }

        // Compute sum using formula
        int sumFormula = n * (n + 1) / 2;

        // Display results
        System.out.println("Sum using for loop: " + sumFor);
        System.out.println("Sum using formula: " + sumFormula);

        // Compare results
        if (sumFor == sumFormula) {
            System.out.println("Both results are correct and match.");
        } else {
            System.out.println("There is a mismatch in the results.");
        }
    }
}
