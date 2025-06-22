import java.util.Scanner;

public class GcdLcmCalculator {

    // Method to calculate GCD using Euclidean algorithm
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Method to calculate LCM using GCD
    public static int calculateLCM(int a, int b) {
        return (a * b) / calculateGCD(a, b);
    }

    // Method to take input
    public static int[] getInput(Scanner sc) {
        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();
        return new int[] { num1, num2 };
    }

    // Method to display result
    public static void displayResult(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = getInput(sc);
        int a = numbers[0];
        int b = numbers[1];

        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b);

        displayResult(a, b, gcd, lcm);

        sc.close();
    }
}
