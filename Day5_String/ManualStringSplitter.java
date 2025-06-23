package Day5_String;

import java.util.Scanner;

public class ManualStringSplitter {

    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string
        }
        return count;
    }

    public static String[] manualSplit(String str) {
        int length = getLength(str);
        int spaceCount = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ')
                spaceCount++;
        }

        int[] spaceIndexes = new int[spaceCount + 2]; // +1 for start, +1 for end
        spaceIndexes[0] = -1; // before the first character
        int index = 1;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }

        spaceIndexes[spaceCount + 1] = length;

        String[] words = new String[spaceCount + 1];

        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
        }

        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] builtInSplit = text.split(" ");
        String[] manualSplit = manualSplit(text);

        boolean areSame = compareArrays(builtInSplit, manualSplit);

        System.out.println("\nBuilt-in split():");
        for (String word : builtInSplit) {
            System.out.println(word);
        }

        System.out.println("\nManual split():");
        for (String word : manualSplit) {
            System.out.println(word);
        }

        System.out.println("\nAre both methods equal? " + (areSame ? "Yes" : "No"));

        sc.close();
    }
}
