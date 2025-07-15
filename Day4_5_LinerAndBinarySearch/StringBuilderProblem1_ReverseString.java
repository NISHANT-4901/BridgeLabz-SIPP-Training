package Day4_5_LinerAndBinarySearch;

public class StringBuilderProblem1_ReverseString {
    public static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        String result = reverse(input);
        System.out.println("Reversed: " + result);
    }
}
