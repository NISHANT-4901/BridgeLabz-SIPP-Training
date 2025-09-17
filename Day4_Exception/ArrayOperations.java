package Day4_Exception;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = null; 
        int index = 0; 
        try {
            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }
}

