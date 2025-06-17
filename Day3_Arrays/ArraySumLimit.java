package Day3_Arrays;

import java.util.Scanner;

public class ArraySumLimit {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        Scanner scanner = new Scanner(System.in);

        // Step 2: Infinite loop to get inputs
        System.out.println("Enter up to 10 positive numbers (0 or negative to stop):");
        while (true) {
            double input = scanner.nextDouble();

            // Step 3: Break on 0 or negative input
            if (input <= 0) {
                break;
            }

            // Step 4: Check array limit
            if (index >= 10) {
                System.out.println("Array limit reached (10 values).");
                break;
            }

            // Step 5: Store value and increment index
            numbers[index++] = input;
        }

        // Step 6: Compute sum
        for (int i = 0; i < index; i++) {
            total += numbers[i];
        }

        // Step 7: Display values and sum
        System.out.println("Entered Numbers:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }

        System.out.println("\nTotal Sum: " + total);

        scanner.close();
    }
}
