package Day1_ProgrammingElements;

import java.util.Scanner;

public class DoubleOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1 & 2: Declare variables and take user input
        System.out.print("Enter value for a: ");
        double a = sc.nextDouble();

        System.out.print("Enter value for b: ");
        double b = sc.nextDouble();

        System.out.print("Enter value for c: ");
        double c = sc.nextDouble();

        // Step 3: Perform the operations and store results
        double result1 = a + b * c; // b * c first, then + a
        double result2 = a * b + c; // a * b first, then + c
        double result3 = c + a / b; // a / b first, then + c
        double result4 = a % b + c; // a % b first, then + c

        // Step 4: Print the results
        System.out.println("\nThe results of Double Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        sc.close();
    }
}
