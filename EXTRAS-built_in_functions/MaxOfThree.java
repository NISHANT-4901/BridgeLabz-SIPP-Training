import java.util.Scanner;

public class MaxOfThree {

    // Method to take input from the user
    public static int getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextInt();
    }

    // Method to find the maximum of three numbers
    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take 3 inputs
        int num1 = getInput(sc, "Enter first number: ");
        int num2 = getInput(sc, "Enter second number: ");
        int num3 = getInput(sc, "Enter third number: ");

        // Find max
        int max = findMaximum(num1, num2, num3);

        // Output
        System.out.println("The maximum of the three numbers is: " + max);

        sc.close();
    }
}
