package Day3_Arrays;

import java.util.Scanner;

public class MatrixToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get rows and columns from user
        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix:");

        // Taking input for the 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Step 2 & 3: Convert 2D to 1D array
        int[] array = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[index++] = matrix[i][j];
            }
        }

        // Output the 1D array
        System.out.println("1D Array:");
        for (int value : array) {
            System.out.print(value + " ");
        }

        scanner.close();
    }
}
