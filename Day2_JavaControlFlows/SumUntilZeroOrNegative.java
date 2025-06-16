import java.util.Scanner;

public class SumUntilZeroOrNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double total = 0.0;

        while (true) {
            // Take input from user
            System.out.print("Enter a number (0 or negative to stop): ");
            double number = sc.nextDouble();

            // Break condition
            if (number <= 0) {
                break;
            }

            // Add to total
            total += number;
        }

        sc.close();

        // Display result
        System.out.println("The total sum is: " + total);
    }
}
