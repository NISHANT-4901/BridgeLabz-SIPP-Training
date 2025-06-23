package Day5_String;

import java.util.Scanner;

public class ArrayIndexDemo {

    public static void generateException(String[] names, int index) {
        String name = names[index];
        System.out.println("Accessed Name: " + name);
    }

    public static void handleArrayIndexException(String[] names, int index) {
        try {
            String name = names[index];
            System.out.println("Accessed Name: " + name);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Handled ArrayIndexOutOfBoundsException: Invalid index.");
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] names = { "Nishant", "Aman", "Riya", "Priya" };
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an index to access name: ");
        int index = sc.nextInt();

        generateException(names, index);

        handleArrayIndexException(names, index);

        sc.close();
    }
}
