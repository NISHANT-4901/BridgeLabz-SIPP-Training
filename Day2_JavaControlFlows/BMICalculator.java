import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // a. Take user input
        System.out.print("Enter your weight in kg: ");
        double weight = sc.nextDouble();

        System.out.print("Enter your height in cm: ");
        double heightCm = sc.nextDouble();

        sc.close();

        // b. Convert cm to meter and calculate BMI
        double heightM = heightCm / 100;
        double bmi = weight / (heightM * heightM);

        // c. Display BMI and determine status
        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.print("Weight Status: ");

        if (bmi <= 18.4) {
            System.out.println("Underweight");
        } else if (bmi <= 24.9) {
            System.out.println("Normal");
        } else if (bmi <= 39.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
