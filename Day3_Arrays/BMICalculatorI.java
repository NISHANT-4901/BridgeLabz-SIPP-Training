package Day3_Arrays;

import java.util.Scanner;

public class BMICalculatorI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Take number of persons
        System.out.print("Enter number of persons: ");
        int count = scanner.nextInt();

        // Step 2: Arrays for data
        double[] weights = new double[count];
        double[] heights = new double[count];
        double[] bmis = new double[count];
        String[] weightStatus = new String[count];

        // Step 3: Take input
        for (int i = 0; i < count; i++) {
            System.out.println("Person #" + (i + 1));
            System.out.print("Enter weight (in kg): ");
            weights[i] = scanner.nextDouble();
            System.out.print("Enter height (in meters): ");
            heights[i] = scanner.nextDouble();

            // Validation
            if (weights[i] <= 0 || heights[i] <= 0) {
                System.out.println("Invalid input. Please enter positive values.");
                i--; // retry current person
            }
        }

        // Step 4: Calculate BMI and determine weight status
        for (int i = 0; i < count; i++) {
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            if (bmis[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmis[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmis[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Step 5: Display data
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Status");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n",
                    heights[i], weights[i], bmis[i], weightStatus[i]);
        }

        scanner.close();
    }
}
