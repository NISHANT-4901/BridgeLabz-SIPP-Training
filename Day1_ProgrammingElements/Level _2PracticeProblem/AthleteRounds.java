package Day1_ProgrammingElements;

import java.util.Scanner;

public class AthleteRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take side lengths of the triangle in meters
        System.out.print("Enter length of side 1 (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter length of side 2 (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter length of side 3 (in meters): ");
        double side3 = sc.nextDouble();

        // Step 2: Calculate the perimeter (1 round distance)
        double perimeter = side1 + side2 + side3;

        // Step 3: Total distance to run is 5 km = 5000 meters
        double totalDistance = 5000.0;

        // Step 4: Calculate number of rounds
        double rounds = totalDistance / perimeter;

        // Step 5: Display the result (rounded to 2 decimal places)
        System.out.printf("The total number of rounds the athlete will run is %.2f to complete 5 km.%n", rounds);

        sc.close();
    }
}
