package Day1_ProgrammingElements;

import java.util.Scanner;

public class KmToMilesConverter {
    public static void main(String[] args) {
        // Create Scanner object to take input
        Scanner input = new Scanner(System.in);

        // Declare variable
        double km;

        // Take user input
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();

        // Convert km to miles (1 mile = 1.6 km)
        double miles = km / 1.6;

        // Output
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");

        input.close();
    }
}
