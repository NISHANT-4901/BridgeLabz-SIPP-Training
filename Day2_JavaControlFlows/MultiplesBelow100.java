import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();
        sc.close();

        // Validate input
        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Please enter a positive integer less than 100.");
            return;
        }

        System.out.println("Multiples of " + number + " below 100 (in reverse order):");

        // Loop from 100 down to 1
        for (int i = 100; i >= 1; i--) {
            if (i % number == 0) {
                System.out.println(i);
            }
        }
    }
}
