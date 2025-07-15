package Day4_5_LinerAndBinarySearch;

public class LinearSearchProblem1_FirstNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 0, -3, 9 };
        int index = findFirstNegative(arr);
        System.out.println("Index of first negative number: " + index);
    }
}
