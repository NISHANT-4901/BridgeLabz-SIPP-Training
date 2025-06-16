import java.util.Scanner;

public class OddEvenPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a natural number (positive integer): ");
        int number = sc.nextInt();
        sc.close();

        // Check for valid input
        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive natural number.");
            return;
        }

        // Loop from 1 to number and check odd/even
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is an even number.");
            } else {
                System.out.println(i + " is an odd number.");
            }
        }
    }
}
