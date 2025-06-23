package Day5_String;

import java.util.Scanner;

public class TrimStringWithCharAt {

    public static int[] getTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[] { start, end };
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length())
            return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with leading and trailing spaces: ");
        String input = sc.nextLine();

        int[] indices = getTrimIndices(input);
        String trimmedByCharAt = customSubstring(input, indices[0], indices[1]);
        String trimmedByBuiltIn = input.trim();

        boolean isEqual = compareStrings(trimmedByCharAt, trimmedByBuiltIn);

        System.out.println("Trimmed using charAt(): '" + trimmedByCharAt + "'");
        System.out.println("Trimmed using trim():   '" + trimmedByBuiltIn + "'");
        System.out.println("Are both strings equal? " + (isEqual ? "Yes" : "No"));

        sc.close();
    }
}
