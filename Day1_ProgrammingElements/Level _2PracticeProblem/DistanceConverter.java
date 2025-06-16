package Day1_ProgrammingElements;

import java.util.Scanner;

public class DistanceConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: distance in feet
        System.out.print("Enter distance in feet: ");
        double feet = sc.nextDouble();

        // Conversion
        double yards = feet / 3.0;
        double miles = yards / 1760.0;

        // Output
        System.out.println("The distance in yards is " + yards +
                " while the distance in miles is " + miles);

        sc.close();
    }
}
