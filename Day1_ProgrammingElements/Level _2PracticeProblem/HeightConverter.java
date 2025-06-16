package Day1_ProgrammingElements;

import java.util.Scanner;

public class HeightConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input for height in cm
        System.out.print("Enter your height in centimeters: ");
        double heightCm = sc.nextDouble();

        // Convert cm to total inches
        double totalInches = heightCm / 2.54;

        // Convert inches to feet and remaining inches
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;

        // Output result
        System.out.printf("Your Height in cm is %.2f while in feet is %d and inches is %.2f\n",
                heightCm, feet, inches);

        sc.close();
    }
}
