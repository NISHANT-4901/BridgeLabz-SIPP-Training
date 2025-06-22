import java.util.Scanner;

public class StringReverser {

    // Method to reverse a string manually
    public static String reverseString(String str) {
        char[] chars = str.toCharArray();
        String reversed = "";

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed += chars[i];
        }

        return reversed;
    }

    // Method to get input from user
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string to reverse: ");
        return sc.nextLine();
    }

    // Method to display reversed result
    public static void displayResult(String original, String reversed) {
        System.out.println("Original String: " + original);
        System.out.println("Reversed String: " + reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String original = getInput(sc);
        String reversed = reverseString(original);
        displayResult(original, reversed);
        sc.close();
    }
}
