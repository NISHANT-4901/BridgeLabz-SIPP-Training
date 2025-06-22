import java.util.Scanner;

public class LexicographicalStringComparer {

    // Method to compare two strings lexicographically
    public static int compareStrings(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());

        for (int i = 0; i < len; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (c1 != c2) {
                return c1 - c2; // positive if str1 > str2, negative if str1 < str2
            }
        }

        // If all characters so far are equal, compare lengths
        return str1.length() - str2.length();
    }

    // Method to display result
    public static void displayResult(String str1, String str2, int result) {
        if (result < 0) {
            System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\" in lexicographical order.");
        } else if (result > 0) {
            System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\" in lexicographical order.");
        } else {
            System.out.println("Both strings are equal.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        int result = compareStrings(str1, str2);
        displayResult(str1, str2, result);

        sc.close();
    }
}
