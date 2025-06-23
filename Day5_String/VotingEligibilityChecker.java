package Day5_String;

import java.util.Scanner;
import java.util.Random;

public class VotingEligibilityChecker {

    public static int[] generateRandomAges(int count) {
        Random rand = new Random();
        int[] ages = new int[count];
        for (int i = 0; i < count; i++) {
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0)
                result[i][1] = "Cannot Vote";
            else if (ages[i] >= 18)
                result[i][1] = "Can Vote";
            else
                result[i][1] = "Cannot Vote";
        }
        return result;
    }

    public static void displayEligibility(String[][] data) {
        System.out.println("Age\tEligibility");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] result = checkVotingEligibility(ages);
        displayEligibility(result);

        sc.close();
    }
}
