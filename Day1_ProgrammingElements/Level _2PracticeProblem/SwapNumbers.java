package Day1_ProgrammingElements;

import java.util.Scanner;

public class SwapNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get inputs
        System.out.print("Enter first number (number1): ");
        int number1 = sc.nextInt();

        System.out.print("Enter second number (number2): ");
        int number2 = sc.nextInt();

        // Step 2: Swap using a temporary variable
        int temp = number1;
        number1 = number2;
        number2 = temp;

        // Step 3: Display the swapped values
        System.out.println("The swapped numbers are " + number1 + " and " + number2);

        sc.close();
    }
}
