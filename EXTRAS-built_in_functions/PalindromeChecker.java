import java.util.Scanner;

public class PalindromeChecker {

    // Function to get input from user
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string to check if it's a palindrome: ");
        return sc.nextLine().replaceAll("\\s+", "").toLowerCase(); // normalize: remove spaces & lowercase
    }

    // Function to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Function to display result
    public static void displayResult(String original, boolean result) {
        if (result) {
            System.out.println("\"" + original + "\" is a Palindrome.");
        } else {
            System.out.println("\"" + original + "\" is NOT a Palindrome.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originalInput = getInput(sc);

        boolean result = isPalindrome(originalInput);
        displayResult(originalInput, result);

        sc.close();
    }
}
