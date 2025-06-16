import java.util.Scanner;

public class MultiplesBelow100While {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input from user
        System.out.print("Enter a positive integer less than 100: ");
        int number = sc.nextInt();
        sc.close();

        // Input validation
        if (number <= 0 || number >= 100) {
            System.out.println("Invalid input. Please enter a positive integer less than 100.");
            return;
        }

        System.out.println("Multiples of " + number + " below 100:");

        int counter = 1;

        // while loop to print all multiples of number below 100
        while (counter < 100) {
            if (counter % number == 0) {
                System.out.println(counter);
            }
            counter++;
        }
    }
}
