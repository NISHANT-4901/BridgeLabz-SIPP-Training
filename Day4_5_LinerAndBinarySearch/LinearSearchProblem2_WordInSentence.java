package Day4_5_LinerAndBinarySearch;

public class LinearSearchProblem2_WordInSentence {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
                "Java is fast",
                "Python is easy to learn",
                "C++ is powerful"
        };
        String word = "easy";
        String result = findSentenceWithWord(sentences, word);
        System.out.println("Result: " + result);
    }
}
