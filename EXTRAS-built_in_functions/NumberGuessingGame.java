import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    // Method to generate a guess between low and high (inclusive)
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    // Method to get feedback from the user: "low", "high", or "correct"
    public static String getUserFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "?");
        System.out.print("Enter feedback (low/high/correct): ");
        return sc.nextLine().trim().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1;
        int high = 100;
        boolean found = false;

        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (!found && low <= high) {
            int guess = generateGuess(low, high);
            String feedback = getUserFeedback(sc, guess);

            switch (feedback) {
                case "low":
                    low = guess + 1;
                    break;
                case "high":
                    high = guess - 1;
                    break;
                case "correct":
                    System.out.println("Yay! I guessed your number correctly: " + guess);
                    found = true;
                    break;
                default:
                    System.out.println("Invalid input. Please type 'low', 'high', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("Hmm, seems like something went wrong. Are you sure you followed the rules?");
        }

        sc.close();
    }
}
