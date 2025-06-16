import java.util.Scanner;

public class PowerWithWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter the base number (positive integer): ");
        int number = sc.nextInt();

        System.out.print("Enter the power (non-negative integer): ");
        int power = sc.nextInt();
        sc.close();

        // Input validation
        if (number <= 0 || power < 0) {
            System.out.println("Invalid input. Base must be positive and power must be non-negative.");
            return;
        }

        // Initialize result and counter
        int result = 1;
        int counter = 0;

        // Loop till counter equals power
        while (counter != power) {
            result *= number;
            counter++;
        }

        // Output the result
        System.out.println(number + " raised to the power " + power + " is: " + result);
    }
}
