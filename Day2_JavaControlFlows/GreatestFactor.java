import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();

        // Check for valid input
        if (number <= 1) {
            System.out.println("No greatest factor exists for this input.");
            return;
        }

        // Initialize the greatest factor variable
        int greatestFactor = 1;

        // Start loop from number - 1 down to 1
        for (int i = number - 1; i >= 1; i--) {
            if (number % i == 0) {
                greatestFactor = i;
                break; // First factor from reverse is the greatest
            }
        }

        // Output the result
        System.out.println("The greatest factor of " + number + " (excluding itself) is: " + greatestFactor);
    }
}
