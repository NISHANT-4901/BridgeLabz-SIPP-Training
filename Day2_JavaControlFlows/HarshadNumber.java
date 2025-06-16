import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        sc.close();

        int sum = 0;
        int originalNumber = number;

        // Extract digits and calculate sum
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            number = number / 10;
        }

        // Check Harshad condition
        if (originalNumber % sum == 0) {
            System.out.println(originalNumber + " is a Harshad Number.");
        } else {
            System.out.println(originalNumber + " is NOT a Harshad Number.");
        }
    }
}
