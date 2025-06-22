import java.util.Scanner;

public class RemoveDuplicatesFromString {

    // Method to remove duplicate characters
    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[256]; // ASCII character set

        for (char ch : str.toCharArray()) {
            if (!seen[ch]) {
                seen[ch] = true;
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Method to take input from user
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    // Method to display result
    public static void displayResult(String original, String modified) {
        System.out.println("Original String: " + original);
        System.out.println("String after removing duplicates: " + modified);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = getInput(sc);
        String modified = removeDuplicates(original);
        displayResult(original, modified);
        sc.close();
    }
}
