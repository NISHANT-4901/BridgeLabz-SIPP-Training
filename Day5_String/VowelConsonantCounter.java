package Day5_String;

import java.util.Scanner;

public class VowelConsonantCounter {

    public static String checkCharacterType(char ch) {
        if (ch >= 'A' && ch <= 'Z')
            ch = (char) (ch + 32);
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                return "Vowel";
            else
                return "Consonant";
        }
        return "Not a Letter";
    }

    public static int[] countVowelsConsonants(String text) {
        int[] count = new int[2];
        for (int i = 0; i < text.length(); i++) {
            String type = checkCharacterType(text.charAt(i));
            if (type.equals("Vowel"))
                count[0]++;
            else if (type.equals("Consonant"))
                count[1]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        int[] counts = countVowelsConsonants(input);

        System.out.println("Total Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);

        sc.close();
    }
}
