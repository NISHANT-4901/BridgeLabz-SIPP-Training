package Day1_ProgrammingElements;

import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: two floating-point numbers
        System.out.print("Enter first number: ");
        double number1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double number2 = sc.nextDouble();

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = number2 != 0 ? number1 / number2 : Double.NaN;

        // Output results
        System.out.println("\nThe addition, subtraction, multiplication, and division value of two numbers "
                + number1 + " and " + number2 + " is:");
        System.out.println("Addition       = " + addition);
        System.out.println("Subtraction    = " + subtraction);
        System.out.println("Multiplication = " + multiplication);
        if (number2 != 0) {
            System.out.println("Division       = " + division);
        } else {
            System.out.println("Division       = Undefined (cannot divide by zero)");
        }

        sc.close();
    }
}
