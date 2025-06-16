import java.util.Scanner;

public class RocketLaunchI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter countdown starting number: ");
        int counter = sc.nextInt();
        sc.close();

        // Countdown using for loop
        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        // Final message
        System.out.println("Lift off! 🚀");
    }
}
