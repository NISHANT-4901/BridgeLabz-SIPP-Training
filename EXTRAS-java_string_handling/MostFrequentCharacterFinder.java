import java.util.Scanner;

public class MostFrequentCharacterFinder {

    // Method to find the most frequent character
    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256]; // ASCII character frequency

        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        int maxFreq = 0;
        char mostFrequent = ' ';

        for (char ch : str.toCharArray()) {
            if (freq[ch] > maxFreq) {
                maxFreq = freq[ch];
                mostFrequent = ch;
            }
        }

        return mostFrequent;
    }

    // Method to get input from user
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInput(sc);
        char result = findMostFrequentChar(input);
        System.out.println("Most Frequent Character: '" + result + "'");
        sc.close();
    }
}
