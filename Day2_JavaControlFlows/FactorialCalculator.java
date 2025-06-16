import java.util.Scanner;

public class FactorialCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();

        // Check for valid input
        if (number < 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        // Calculate factorial using while loop
        long factorial = 1;
        int i = 1;

        while (i <= number) {
            factorial *= i;
            i++;
        }

        // Output result
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
