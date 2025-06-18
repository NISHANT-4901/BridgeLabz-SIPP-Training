package Day4_Methods;

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Method to create a random matrix
    public static double[][] generateRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // 0-9
        return matrix;
    }

    // Method to transpose a matrix
    public static double[][] transpose(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        double[][] result = new double[cols][rows];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    // Determinant of 2x2
    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    // Determinant of 3x3
    public static double determinant3x3(double[][] m) {
        return m[0][0] * (m[1][1] * m[2][2] - m[1][2] * m[2][1]) -
                m[0][1] * (m[1][0] * m[2][2] - m[1][2] * m[2][0]) +
                m[0][2] * (m[1][0] * m[2][1] - m[1][1] * m[2][0]);
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (det == 0)
            return null;
        double[][] inv = {
                { m[1][1] / det, -m[0][1] / det },
                { -m[1][0] / det, m[0][0] / det }
        };
        return inv;
    }

    // Inverse of 3x3 matrix
    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (det == 0)
            return null;

        double[][] cofactor = new double[3][3];

        cofactor[0][0] = (m[1][1] * m[2][2] - m[1][2] * m[2][1]);
        cofactor[0][1] = -(m[1][0] * m[2][2] - m[1][2] * m[2][0]);
        cofactor[0][2] = (m[1][0] * m[2][1] - m[1][1] * m[2][0]);

        cofactor[1][0] = -(m[0][1] * m[2][2] - m[0][2] * m[2][1]);
        cofactor[1][1] = (m[0][0] * m[2][2] - m[0][2] * m[2][0]);
        cofactor[1][2] = -(m[0][0] * m[2][1] - m[0][1] * m[2][0]);

        cofactor[2][0] = (m[0][1] * m[1][2] - m[0][2] * m[1][1]);
        cofactor[2][1] = -(m[0][0] * m[1][2] - m[0][2] * m[1][0]);
        cofactor[2][2] = (m[0][0] * m[1][1] - m[0][1] * m[1][0]);

        // Transpose cofactor to get adjugate
        double[][] adjugate = transpose(cofactor);

        // Divide by determinant
        double[][] inverse = new double[3][3];
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                inverse[i][j] = adjugate[i][j] / det;

        return inverse;
    }

    // Display any matrix
    public static void displayMatrix(double[][] m) {
        for (double[] row : m) {
            for (double value : row) {
                System.out.printf("%8.2f", value);
            }
            System.out.println();
        }
    }

    // Main program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter matrix size (2 or 3): ");
        int size = scanner.nextInt();

        if (size != 2 && size != 3) {
            System.out.println("Only 2x2 and 3x3 matrices are supported.");
            return;
        }

        double[][] matrix = generateRandomMatrix(size, size);
        System.out.println("\nOriginal Matrix:");
        displayMatrix(matrix);

        System.out.println("\nTranspose:");
        displayMatrix(transpose(matrix));

        if (size == 2) {
            double det = determinant2x2(matrix);
            System.out.printf("\nDeterminant: %.2f\n", det);
            double[][] inv = inverse2x2(matrix);
            if (inv != null) {
                System.out.println("\nInverse:");
                displayMatrix(inv);
            } else {
                System.out.println("\nMatrix is not invertible (det = 0).");
            }
        } else {
            double det = determinant3x3(matrix);
            System.out.printf("\nDeterminant: %.2f\n", det);
            double[][] inv = inverse3x3(matrix);
            if (inv != null) {
                System.out.println("\nInverse:");
                displayMatrix(inv);
            } else {
                System.out.println("\nMatrix is not invertible (det = 0).");
            }
        }

        scanner.close();
    }
}
