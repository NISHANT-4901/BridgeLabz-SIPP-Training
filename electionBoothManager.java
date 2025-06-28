import java.util.Scanner;

public class electionBoothManager {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Number of Candidate");
        int numberOfCandidate = sc.nextInt();

        while (numberOfCandidate > 0) {
            System.out.println("Enter age of candidate");
            int age = sc.nextInt();
            if (age > 18) {
                int result = logicBuilding(age);
                System.out.println("User desired candidate: - " + result);
            } else {
                System.out.println("You are too mature for voting !!");
            }
            numberOfCandidate--;
        }

    }

    static int logicBuilding(int age) {
        System.out.println("Choose your candidates from : candidate 1 , candidate 2, candidate 3");
        int userChoice = sc.nextInt();
        return userChoice;
    }
}