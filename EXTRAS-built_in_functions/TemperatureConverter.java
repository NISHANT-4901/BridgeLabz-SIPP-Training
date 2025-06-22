import java.util.Scanner;

public class TemperatureConverter {

    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    // Method to display menu and take choice
    public static int getChoice(Scanner sc) {
        System.out.println("Temperature Converter:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
        return sc.nextInt();
    }

    // Method to handle conversion
    public static void handleConversion(int choice, Scanner sc) {
        if (choice == 1) {
            System.out.print("Enter temperature in Fahrenheit: ");
            double f = sc.nextDouble();
            double c = fahrenheitToCelsius(f);
            System.out.printf("Temperature in Celsius: %.2f°C\n", c);
        } else if (choice == 2) {
            System.out.print("Enter temperature in Celsius: ");
            double c = sc.nextDouble();
            double f = celsiusToFahrenheit(c);
            System.out.printf("Temperature in Fahrenheit: %.2f°F\n", f);
        } else {
            System.out.println("Invalid choice!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = getChoice(sc);
        handleConversion(choice, sc);
        sc.close();
    }
}
