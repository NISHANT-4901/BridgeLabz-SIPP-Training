package Day4_Methods;

import java.util.Scanner;

public class SimpleInterestCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 2: Get user input
        System.out.print("Enter Principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Rate of Interest: ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = scanner.nextDouble();

        // Step 3: Call method to calculate SI
        double interest = calculateSimpleInterest(principal, rate, time);

        // Step 4: Output result
        System.out.printf(
                "The Simple Interest is %.2f for Principal %.2f, Rate of Interest %.2f%% and Time %.2f years%n",
                interest, principal, rate, time);

        scanner.close();
    }

    // Step 3: Method to calculate simple interest
    public static double calculateSimpleInterest(double principal, double rate, double time) {
        return (principal * rate * time) / 100.0;
    }
}
