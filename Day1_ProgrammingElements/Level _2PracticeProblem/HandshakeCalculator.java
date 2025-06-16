package Day1_ProgrammingElements;

import java.util.Scanner;

public class HandshakeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of students
        System.out.print("Enter the number of students: ");
        int numberOfStudents = sc.nextInt();

        // Step 2: Check if input is valid (non-negative)
        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            // Step 3: Use formula n * (n - 1) / 2
            int maxHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;

            // Step 4: Display the result
            System.out.println("The maximum number of handshakes among " + numberOfStudents + " students is "
                    + maxHandshakes + ".");
        }

        sc.close();
    }
}
