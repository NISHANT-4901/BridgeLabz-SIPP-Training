package Day4_Methods;

public class RandomStats {

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);

        // Display generated numbers
        System.out.print("Generated 4-digit numbers: ");
        for (int num : randomNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double[] stats = findAverageMinMax(randomNumbers);

        System.out.println("Average: " + stats[0]);
        System.out.println("Minimum: " + stats[1]);
        System.out.println("Maximum: " + stats[2]);
    }

    // Generates 4-digit random numbers and returns an array
    public static int[] generate4DigitRandomArray(int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = (int) (Math.random() * 9000) + 1000; // range: 1000–9999
        }

        return result;
    }

    // Returns average, min, and max in a double array
    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        int sum = 0;

        for (int num : numbers) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
        }

        double average = sum / (double) numbers.length;

        return new double[] { average, min, max };
    }
}
