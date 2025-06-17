package Day3_Arrays;

import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Input number of persons
        System.out.print("Enter the number of persons: ");
        int number = scanner.nextInt();

        double[][] personData = new double[number][3]; // [][0]=weight, [][1]=height, [][2]=BMI
        String[] weightStatus = new String[number];

        // Step 2 & 3: Input, validate and compute BMI + status
        for (int i = 0; i < number; i++) {
            double weight, height;

            // Weight input
            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                weight = scanner.nextDouble();
                if (weight <= 0)
                    System.out.println("Weight must be positive.");
            } while (weight <= 0);

            // Height input
            do {
                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                height = scanner.nextDouble();
                if (height <= 0)
                    System.out.println("Height must be positive.");
            } while (height <= 0);

            double bmi = weight / (height * height);

            // Store values
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            // Determine status
            if (bmi <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmi <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmi <= 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        // Step 4: Display results
        System.out.println("\nBMI Report:");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        scanner.close();
    }
}
