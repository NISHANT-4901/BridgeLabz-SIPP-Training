package Day5_String;

import java.util.Scanner;

public class SubstringComparer {

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String custom = customSubstring(input, start, end);
        String builtIn = input.substring(start, end);
        boolean result = compareStrings(custom, builtIn);

        System.out.println("Custom Substring: " + custom);
        System.out.println("Built-in Substring: " + builtIn);
        System.out.println("Are both substrings equal? " + (result ? "Yes" : "No"));

        sc.close();
    }
}
