package Day5_String;

import java.util.Scanner;

public class ShortestLongestWordFinder {

    public static String[] splitIntoWords(String text) {
        String[] temp = new String[100];
        String word = "";
        int wordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.equals("")) {
                    temp[wordIndex++] = word;
                    word = "";
                }
            }
        }

        if (!word.equals("")) {
            temp[wordIndex++] = word;
        }

        String[] words = new String[wordIndex];
        for (int i = 0; i < wordIndex; i++) {
            words[i] = temp[i];
        }

        return words;
    }

    public static int getLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (Exception e) {
        }
        return count;
    }

    public static String[][] wordLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] wordData) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLength = Integer.parseInt(wordData[0][1]);
        int maxLength = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {
            int length = Integer.parseInt(wordData[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }

        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = splitIntoWords(input);
        String[][] wordData = wordLengths(words);
        int[] result = findShortestLongest(wordData);

        System.out.println("Words and their lengths:");
        for (String[] entry : wordData) {
            System.out.println("Word: " + entry[0] + " | Length: " + entry[1]);
        }

        System.out.println("\nShortest word: " + wordData[result[0]][0]);
        System.out.println("Longest word: " + wordData[result[1]][0]);

        sc.close();
    }
}
