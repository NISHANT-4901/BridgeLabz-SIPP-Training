package Day3_Arrays;

import java.util.Scanner;

public class DigitAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;

        // Step 4 to 6: Extract digits and resize array if needed
        while (number != 0) {
            int digit = number % 10;

            if (index == maxDigit) {
                maxDigit *= 2;
                int[] temp = new int[maxDigit];
                for (int i = 0; i < index; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index++] = digit;
            number /= 10;
        }

        // Step 7: Initialize largest and second largest
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Step 8: Find largest and second largest
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Step 9: Display results
        System.out.print("Digits in the number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\nLargest digit: " + largest);
        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit: Not available (only one unique digit)");
        }

        scanner.close();
    }
}
