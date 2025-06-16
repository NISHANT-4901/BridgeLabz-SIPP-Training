import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();

        // Step 2: Initialize variables
        int sum = 0;
        int originalNumber = number;

        // Step 3: Use while loop to extract digits and compute sum of cubes
        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Extract last digit
            sum += digit * digit * digit; // Add cube of digit to sum
            originalNumber = originalNumber / 10; // Remove last digit
        }

        // Step 4: Check and display result
        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is NOT an Armstrong number.");
        }
    }
}
