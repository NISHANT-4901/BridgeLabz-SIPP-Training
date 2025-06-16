package Day1_ProgrammingElements;

import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of chocolates and number of children
        System.out.print("Enter the number of chocolates: ");
        int numberOfChocolates = sc.nextInt();

        System.out.print("Enter the number of children: ");
        int numberOfChildren = sc.nextInt();

        // Step 2: Check for valid input to avoid division by zero
        if (numberOfChildren <= 0) {
            System.out.println("Number of children must be greater than 0.");
        } else {
            // Step 3: Calculate chocolates per child and remainder
            int chocolatesPerChild = numberOfChocolates / numberOfChildren;
            int remainingChocolates = numberOfChocolates % numberOfChildren;

            // Step 4: Display the results
            System.out.println("The number of chocolates each child gets is " + chocolatesPerChild +
                    " and the number of remaining chocolates is " + remainingChocolates + ".");
        }

        sc.close();
    }
}
