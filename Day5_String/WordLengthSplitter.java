package Day5_String;

import java.util.Scanner;

public class WordLengthSplitter {

    public static String[] splitWords(String text) {
        String[] words = new String[100];
        int index = 0;
        String word = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    words[index++] = word;
                    word = "";
                }
            }
        }
        if (!word.equals("")) {
            words[index++] = word;
        }
        String[] result = new String[index];
        for (int i = 0; i < index; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static int findLength(String word) {
        int count = 0;
        try {
            while (true) {
                word.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static void displayWordLengths(String[][] data) {
        System.out.println("Word\t\tLength");
        for (String[] row : data) {
            System.out.println(row[0] + "\t\t" + Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordLengthArray = getWordLengthArray(words);
        displayWordLengths(wordLengthArray);

        sc.close();
    }
}
