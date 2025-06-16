package Day1_ProgrammingElements;

import java.util.Scanner;

public class TemperaturConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take user input for Fahrenheit
        System.out.print("Enter temperature in Fahrenheit: ");
        double fahrenheit = sc.nextDouble();

        // Step 2: Convert to Celsius using formula
        double celsiusResult = (fahrenheit - 32) * 5 / 9;

        // Step 3: Display the result
        System.out.printf("The %.2f Fahrenheit is %.2f Celsius.%n", fahrenheit, celsiusResult);

        sc.close();
    }
}
