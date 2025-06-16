import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get base number input
        System.out.print("Enter the base (positive integer): ");
        int number = sc.nextInt();

        // Get power input
        System.out.print("Enter the power (non-negative integer): ");
        int power = sc.nextInt();
        sc.close();

        // Check for valid input
        if (number <= 0 || power < 0) {
            System.out.println("Invalid input. Please enter a positive base and non-negative power.");
            return;
        }

        // Calculate power
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }

        // Output the result
        System.out.println(number + " raised to the power " + power + " is: " + result);
    }
}
