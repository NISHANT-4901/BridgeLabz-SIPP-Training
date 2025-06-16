import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from the user
        System.out.print("Enter an integer: ");
        int number = sc.nextInt();
        sc.close();

        int count = 0;
        int originalNumber = number;

        // Handle negative numbers
        number = Math.abs(number);

        // If the number is 0, it has 1 digit
        if (number == 0) {
            count = 1;
        } else {
            // Count digits by dividing by 10
            while (number != 0) {
                number = number / 10;
                count++;
            }
        }

        // Display result
        System.out.println("The number " + originalNumber + " has " + count + " digit(s).");
    }
}
