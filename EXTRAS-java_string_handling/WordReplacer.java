import java.util.Scanner;

public class WordReplacer {

    // Method to replace one word with another in a sentence
    public static String replaceWord(String sentence, String target, String replacement) {
        return sentence.replaceAll("\\b" + target + "\\b", replacement);
    }

    // Method to get user input
    public static String getInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = getInput(sc, "Enter the sentence: ");
        String target = getInput(sc, "Enter the word to replace: ");
        String replacement = getInput(sc, "Enter the replacement word: ");

        String result = replaceWord(sentence, target, replacement);
        System.out.println("Modified Sentence: " + result);

        sc.close();
    }
}
