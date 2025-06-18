package Day4_Methods;

import java.util.Scanner;

public class FactorOperations {

    // Method to find all factors and return them as an array
    public static int[] getFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to find the greatest factor
    public static int getGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int factor : factors) {
            if (factor > max) {
                max = factor;
            }
        }
        return max;
    }

    // Method to calculate the sum of the factors
    public static int getSum(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    // Method to calculate the product of the factors
    public static long getProduct(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    // Method to calculate the product of the cube of factors
    public static double getCubeProduct(int[] factors) {
        double cubeProduct = 1.0;
        for (int factor : factors) {
            cubeProduct *= Math.pow(factor, 3);
        }
        return cubeProduct;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = getFactors(number);

        System.out.print("Factors: ");
        for (int factor : factors) {
            System.out.print(factor + " ");
        }
        System.out.println();

        System.out.println("Greatest Factor: " + getGreatestFactor(factors));
        System.out.println("Sum of Factors: " + getSum(factors));
        System.out.println("Product of Factors: " + getProduct(factors));
        System.out.printf("Product of Cubes of Factors: %.0f\n", getCubeProduct(factors));

        scanner.close();
    }
}
