package Day1_ProgrammingElements;

import java.util.Scanner;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input base and height in cm
        System.out.print("Enter base of the triangle (in cm): ");
        double base = sc.nextDouble();

        System.out.print("Enter height of the triangle (in cm): ");
        double height = sc.nextDouble();

        // Calculate area in square centimeters
        double areaSqCm = 0.5 * base * height;

        // Convert to square inches (1 sq in = 6.4516 sq cm)
        double areaSqIn = areaSqCm / 6.4516;

        // Output
        System.out.printf("The Area of the triangle in sq cm is %.2f and in sq in is %.2f\n",
                areaSqCm, areaSqIn);

        sc.close();
    }
}
