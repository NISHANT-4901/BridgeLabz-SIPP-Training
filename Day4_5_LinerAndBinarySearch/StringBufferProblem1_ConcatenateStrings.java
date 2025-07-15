package Day4_5_LinerAndBinarySearch;

public class StringBufferProblem1_ConcatenateStrings {
    public static String concatenate(String[] arr) {
        StringBuffer sb = new StringBuffer();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = { "Java", " ", "is", " ", "fast" };
        String result = concatenate(words);
        System.out.println("Concatenated: " + result);
    }
}
