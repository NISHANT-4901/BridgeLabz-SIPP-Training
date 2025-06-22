import java.util.Scanner;

public class BasicCalculator {

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }

    // Prompt user for operation
    public static int getOperation(Scanner sc) {
        System.out.println("Choose Operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.print("Enter your choice (1-4): ");
        return sc.nextInt();
    }

    // Prompt user for two numbers
    public static double[] getOperands(Scanner sc) {
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();
        return new double[] { num1, num2 };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int operation = getOperation(sc);
        double[] operands = getOperands(sc);
        double a = operands[0], b = operands[1];
        double result = 0;

        switch (operation) {
            case 1:
                result = add(a, b);
                System.out.println("Result: " + result);
                break;
            case 2:
                result = subtract(a, b);
                System.out.println("Result: " + result);
                break;
            case 3:
                result = multiply(a, b);
                System.out.println("Result: " + result);
                break;
            case 4:
                result = divide(a, b);
                if (!Double.isNaN(result))
                    System.out.println("Result: " + result);
                break;
            default:
                System.out.println("Invalid operation selected.");
        }

        sc.close();
    }
}
