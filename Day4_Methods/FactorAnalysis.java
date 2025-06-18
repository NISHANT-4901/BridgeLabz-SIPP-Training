package Day4_Methods;

import java.util.Scanner;

public class FactorAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get input from user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // 2. Get factors
        int[] factors = findFactors(number);

        // Display factors
        System.out.print("Factors of " + number + ": ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        // 4. Sum of factors
        int sum = getSum(factors);
        System.out.println("Sum of factors: " + sum);

        // 5. Product of factors
        int product = getProduct(factors);
        System.out.println("Product of factors: " + product);

        // 6. Sum of squares of factors
        int sumOfSquares = getSumOfSquares(factors);
        System.out.println("Sum of squares of factors: " + sumOfSquares);

        scanner.close();
    }

    // Step 2 & 3: Get factors
    public static int[] findFactors(int num) {
        int count = 0;

        // First loop to count
        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        // Second loop to store
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                factors[index++] = i;
            }
        }

        return factors;
    }

    // Step 4: Sum of factors
    public static int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    // Step 5: Product of factors
    public static int getProduct(int[] arr) {
        int product = 1;
        for (int num : arr) {
            product *= num;
        }
        return product;
    }

    // Step 6: Sum of squares
    public static int getSumOfSquares(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += Math.pow(num, 2);
        }
        return sum;
    }
}
