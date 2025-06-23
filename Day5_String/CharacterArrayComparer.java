package Day5_String;

import java.util.Scanner;

public class CharacterArrayComparer {

    // Method 1: Custom method to convert string to char array (without using
    // toCharArray)
    public static char[] getCharsManually(String str) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        return chars;
    }

    // Method 2: Compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length)
            return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    // Utility method to print array
    public static void printCharArray(char[] arr, String label) {
        System.out.print(label + ": ");
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] manualChars = getCharsManually(input); // Using user-defined method
        char[] builtinChars = input.toCharArray(); // Using toCharArray()

        printCharArray(manualChars, "Manual Method");
        printCharArray(builtinChars, "Built-in toCharArray");

        boolean result = compareCharArrays(manualChars, builtinChars);
        System.out.println("Do both methods return the same result? " + (result ? "Yes" : "No"));

        sc.close();
    }
}
