import java.util.Scanner;

public class SubstringCounter {

    // Method to count occurrences of a substring
    public static int countOccurrences(String text, String sub) {
        int count = 0;
        int index = 0;

        while ((index = text.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length(); // Move past the last found substring
        }

        return count;
    }

    // Method to get input from user
    public static String getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String text = getInput(sc, "Enter the main string: ");
        String sub = getInput(sc, "Enter the substring to search: ");

        int count = countOccurrences(text, sub);
        System.out.println("The substring \"" + sub + "\" occurs " + count + " time(s).");

        sc.close();
    }
}
