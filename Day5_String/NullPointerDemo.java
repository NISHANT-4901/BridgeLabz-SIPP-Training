package Day5_String;

public class NullPointerDemo {

    public static void generateException() {
        String text = null;
        int length = text.length();
        System.out.println("Length: " + length);
    }

    public static void handleNullPointerException() {
        try {
            String text = null;
            int length = text.length();
            System.out.println("Length: " + length);
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: Null reference used.");
        } catch (RuntimeException e) {
            System.out.println("Handled RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateException();
        handleNullPointerException();
    }
}
