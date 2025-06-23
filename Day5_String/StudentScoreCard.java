package Day5_String;

import java.util.Random;
import java.util.Scanner;

public class StudentScoreCard {

    public static int[][] generatePCMScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        Random rand = new Random();
        for (int i = 0; i < studentCount; i++) {
            scores[i][0] = 40 + rand.nextInt(61);
            scores[i][1] = 40 + rand.nextInt(61);
            scores[i][2] = 40 + rand.nextInt(61);
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        int n = scores.length;
        double[][] results = new double[n][3];
        for (int i = 0; i < n; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static String[] calculateGrades(double[][] results) {
        int n = results.length;
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            double percentage = results[i][2];
            if (percentage >= 80)
                grades[i] = "A";
            else if (percentage >= 70)
                grades[i] = "B";
            else if (percentage >= 60)
                grades[i] = "C";
            else if (percentage >= 50)
                grades[i] = "D";
            else if (percentage >= 40)
                grades[i] = "E";
            else
                grades[i] = "R";
        }
        return grades;
    }

    public static void displayScorecard(int[][] scores, double[][] results, String[] grades) {
        System.out.println("S.No\tPhysics\tChemistry\tMaths\tTotal\tAverage\t\tPercentage\tGrade");
        for (int i = 0; i < scores.length; i++) {
            System.out.println((i + 1) + "\t" +
                    scores[i][0] + "\t" +
                    scores[i][1] + "\t\t" +
                    scores[i][2] + "\t" +
                    (int) results[i][0] + "\t" +
                    results[i][1] + "\t\t" +
                    results[i][2] + "\t\t" +
                    grades[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] scores = generatePCMScores(n);
        double[][] results = calculateResults(scores);
        String[] grades = calculateGrades(results);

        displayScorecard(scores, results, grades);

        sc.close();
    }
}
