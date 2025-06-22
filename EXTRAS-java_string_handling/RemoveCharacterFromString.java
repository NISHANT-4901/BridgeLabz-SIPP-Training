import java.util.Scanner;

public class RemoveCharacterFromString {

    // Method to remove all occurrences of a character from a string
    public static String removeChar(String str, char target) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch != target) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Method to get input string from user
    public static String getInputString(Scanner sc) {
        System.out.print("Enter the string: ");
        return sc.nextLine();
    }

    // Method to get character to remove from user
    public static char getCharacterToRemove(Scanner sc) {
        System.out.print("Enter the character to remove: ");
        return sc.next().charAt(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInputString(sc);
        char target = getCharacterToRemove(sc);

        String modified = removeChar(input, target);
        System.out.println("Modified String: " + modified);
        sc.close();
    }
}
