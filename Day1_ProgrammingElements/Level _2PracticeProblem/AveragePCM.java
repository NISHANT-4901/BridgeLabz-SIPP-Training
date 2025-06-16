package Day1_ProgrammingElements;

public class AveragePCM {
    public static void main(String[] args) {
        // Marks out of 100
        int maths = 94;
        int physics = 95;
        int chemistry = 96;

        // Calculate average
        double average = (maths + physics + chemistry) / 3.0;

        // Output the result
        System.out.println("Sam’s average mark in PCM is " + average);
    }
}
