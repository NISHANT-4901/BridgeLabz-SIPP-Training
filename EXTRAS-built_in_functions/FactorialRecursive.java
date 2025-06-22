import java.util.Scanner;

public class FactorialRecursive {

    // Function to take user input
    public static int getInput(Scanner sc) {
        System.out.print("Enter a non-negative integer to calculate its factorial: ");
        return sc.nextInt();
    }

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers.");
        }
        if (n == 0 || n == 1)
            return 1;
        return n * factorial(n - 1);
    }

    // Function to display result
    public static void displayResult(int number, long result) {
        System.out.println("Factorial of " + number + " is: " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = getInput(sc);
        long fact = factorial(num);
        displayResult(num, fact);

        sc.close();
    }
}
