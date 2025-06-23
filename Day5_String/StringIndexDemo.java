package Day5_String;

import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text, int index) {
        char ch = text.charAt(index);
        System.out.println("Character at index: " + ch);
    }

    public static void handleStringIndexException(String text, int index) {
        try {
            char ch = text.charAt(index);
            System.out.println("Character at index: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Handled StringIndexOutOfBoundsException: Invalid string index.");
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.print("Enter an index to access: ");
        int index = sc.nextInt();

        generateException(input, index);
        handleStringIndexException(input, index);

        sc.close();
    }
}
