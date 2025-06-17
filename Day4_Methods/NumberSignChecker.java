package Day4_Methods;

import java.util.Scanner;

public class NumberSignChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get integer input from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Step 2: Call method and display result
        int result = checkNumberSign(number);

        if (result == 1) {
            System.out.println("The number is positive.");
        } else if (result == -1) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        scanner.close();
    }

    // Step 2: Method to check number sign
    public static int checkNumberSign(int num) {
        if (num > 0)
            return 1;
        else if (num < 0)
            return -1;
        else
            return 0;
    }
}
