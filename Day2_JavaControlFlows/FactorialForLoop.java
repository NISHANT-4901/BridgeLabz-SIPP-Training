import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();

        // Check for valid natural number
        if (number < 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        // Calculate factorial using for loop
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Output result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
