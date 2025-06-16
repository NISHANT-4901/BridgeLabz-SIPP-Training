import java.util.Scanner;

public class FactorsWithWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive integer: ");
        int number = sc.nextInt();
        sc.close();

        // Check if the number is positive
        if (number <= 0) {
            System.out.println("Invalid input. Please enter a positive integer.");
            return;
        }

        // Initialize counter
        int counter = 1;

        // Print factors using while loop
        System.out.println("Factors of " + number + " are:");
        while (counter <= number) {
            if (number % counter == 0) {
                System.out.println(counter);
            }
            counter++;
        }
    }
}
