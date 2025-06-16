import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;
        double number;

        // Prompt first input
        System.out.print("Enter a number (0 to stop): ");
        number = sc.nextDouble();

        // Loop until user enters 0
        while (number != 0) {
            total += number;

            // Prompt for next input
            System.out.print("Enter a number (0 to stop): ");
            number = sc.nextDouble();
        }

        sc.close();

        // Display result
        System.out.println("The total sum is: " + total);
    }
}
