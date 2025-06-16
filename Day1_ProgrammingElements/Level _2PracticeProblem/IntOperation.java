package Day1_ProgrammingElements;

import java.util.Scanner;

public class IntOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter value for a: ");
        int a = sc.nextInt();

        System.out.print("Enter value for b: ");
        int b = sc.nextInt();

        System.out.print("Enter value for c: ");
        int c = sc.nextInt();

        // Operations
        int result1 = a + b * c; // Multiplication has higher precedence
        int result2 = a * b + c; // Multiplication first, then addition
        int result3 = c + a / b; // Division first, then addition
        int result4 = a % b + c; // Modulo first, then addition

        // Output
        System.out.println("The results of Int Operations are:");
        System.out.println("a + b * c = " + result1);
        System.out.println("a * b + c = " + result2);
        System.out.println("c + a / b = " + result3);
        System.out.println("a % b + c = " + result4);

        sc.close();
    }
}
