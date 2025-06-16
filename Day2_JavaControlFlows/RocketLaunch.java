import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter countdown starting number: ");
        int counter = sc.nextInt();
        sc.close();

        // Countdown using while loop
        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        // Final message
        System.out.println("Lift off! 🚀");
    }
}
