import java.util.Scanner;

public class LongestWordFinder {

    // Method to find the longest word
    public static String findLongestWord(String sentence) {
        String[] words = sentence.split("\\s+"); // Split by whitespace
        String longest = "";

        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }

        return longest;
    }

    // Method to get input from user
    public static String getInput(Scanner sc) {
        System.out.print("Enter a sentence: ");
        return sc.nextLine();
    }

    // Method to display result
    public static void displayResult(String longest) {
        System.out.println("The longest word is: " + longest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = getInput(sc);
        String longest = findLongestWord(sentence);
        displayResult(longest);
        sc.close();
    }
}
