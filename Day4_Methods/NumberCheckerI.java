package Day4_Methods;

import java.util.Scanner;

public class NumberCheckerI {

    // Method to count number of digits
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // Method to return digits array
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Method to find sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // Method to find sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // Method to check Harshad number
    public static boolean isHarshad(int number, int sumOfDigits) {
        return number % sumOfDigits == 0;
    }

    // Method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;
        for (int f : freq) {
            if (f > 0)
                count++;
        }

        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }

        return result;
    }

    // Main method to test everything
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] digits = getDigits(number);
        int digitCount = countDigits(number);
        int digitSum = sumOfDigits(digits);
        int digitSquareSum = sumOfSquares(digits);
        boolean harshad = isHarshad(number, digitSum);
        int[][] frequency = digitFrequency(digits);

        System.out.println("Total Digits: " + digitCount);
        System.out.print("Digits: ");
        for (int d : digits)
            System.out.print(d + " ");
        System.out.println("\nSum of Digits: " + digitSum);
        System.out.println("Sum of Squares of Digits: " + digitSquareSum);
        System.out.println("Is Harshad Number: " + (harshad ? "Yes" : "No"));

        System.out.println("Digit Frequencies:");
        for (int[] row : frequency) {
            System.out.println("Digit: " + row[0] + " -> Count: " + row[1]);
        }

        sc.close(); 
    }
}
