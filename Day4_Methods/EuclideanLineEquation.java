package Day4_Methods;

import java.util.Scanner;

public class EuclideanLineEquation {

    // Method to calculate Euclidean distance between two points
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    // Method to calculate slope and y-intercept and return them in an array
    public static double[] calculateLineEquation(double x1, double y1, double x2, double y2) {
        double[] result = new double[2];
        double slope = (y2 - y1) / (x2 - x1); // m
        double intercept = y1 - slope * x1; // b
        result[0] = slope;
        result[1] = intercept;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take input for two points
        System.out.print("Enter x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = sc.nextDouble();

        // Calculate Euclidean distance
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.println("Euclidean Distance: " + distance);

        // Calculate Line Equation
        double[] line = calculateLineEquation(x1, y1, x2, y2);
        double slope = line[0];
        double intercept = line[1];
        System.out.println("Equation of line: y = " + slope + " * x + " + intercept);

        sc.close();
    }
}
