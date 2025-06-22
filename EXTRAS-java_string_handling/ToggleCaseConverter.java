import java.util.Scanner;

public class ToggleCaseConverter {

    // Method to toggle the case of characters in a string
    public static String toggleCase(String str) {
        StringBuilder toggled = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                toggled.append(Character.toLowerCase(ch));
            } else if (Character.isLowerCase(ch)) {
                toggled.append(Character.toUpperCase(ch));
            } else {
                toggled.append(ch); // leave non-alphabetic characters unchanged
            }
        }

        return toggled.toString();
    }

    // Method to get user input
    public static String getInput(Scanner sc) {
        System.out.print("Enter a string: ");
        return sc.nextLine();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = getInput(sc);
        String output = toggleCase(input);
        System.out.println("Toggled Case: " + output);
        sc.close();
    }
}
