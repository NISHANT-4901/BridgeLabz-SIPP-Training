package Day1_ProgrammingElements;

import java.util.Scanner;

public class WeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Get weight input in pounds
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = sc.nextDouble();

        // Step 2: Convert to kilograms (1 pound = 0.454545 kg)
        double weightInKg = weightInPounds / 2.2;

        // Step 3: Print result
        System.out.printf("The weight of the person in pounds is %.2f and in kg is %.2f.%n", weightInPounds,
                weightInKg);

        sc.close();
    }
}
