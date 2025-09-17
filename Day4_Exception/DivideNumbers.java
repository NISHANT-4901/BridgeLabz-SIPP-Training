package Day4_Exception;

import java.util.Scanner;
import java.util.InputMismatchException;
public class DivideNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int result = num1 / num2;
            scanner.close();
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Divided by zero operation cannot possible");
        } catch (InputMismatchException e) {
            System.out.println("You must enter an int value.");
        }
    }
}

