package Day4_5_LinerAndBinarySearch;

public class BinarySearchProblem2_FindPeakElement {
    public static int findPeak(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 20, 4, 1, 0 };
        int peak = findPeak(arr);
        System.out.println("Peak Element: " + peak);
    }
}
