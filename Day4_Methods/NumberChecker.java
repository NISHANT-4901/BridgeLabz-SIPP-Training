package Day4_Methods;

import java.util.Scanner;

public class NumberChecker {

    // Method to get sum of proper divisors
    public static int getSumOfDivisors(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0)
                sum += i;
        }
        return sum;
    }

    // Method to check Perfect Number
    public static boolean isPerfect(int number) {
        return getSumOfDivisors(number) == number;
    }

    // Method to check Abundant Number
    public static boolean isAbundant(int number) {
        return getSumOfDivisors(number) > number;
    }

    // Method to check Deficient Number
    public static boolean isDeficient(int number) {
        return getSumOfDivisors(number) < number;
    }

    // Method to calculate factorial
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++)
            fact *= i;
        return fact;
    }

    // Method to check Strong Number
    public static boolean isStrong(int number) {
        int temp = number;
        int sum = 0;
        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Perfect Number: " + isPerfect(num));
        System.out.println("Abundant Number: " + isAbundant(num));
        System.out.println("Deficient Number: " + isDeficient(num));
        System.out.println("Strong Number: " + isStrong(num));

        sc.close();
    }
}
