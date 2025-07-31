package OnlineExamSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Welcome message
        System.out.println(" Welcome to Online Exam Portal");
        System.out.println("Press Enter to continue...");
        sc.nextLine();

        // Step 2: Take student details
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter University Roll Number: ");
        String roll = sc.nextLine();

        // Step 3: Show available subjects
        System.out.println("\nChoose any one subject out of these options:");
        List<String> subjects = Subject.getAvailableSubjects();
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i));
        }

        System.out.print("Enter your choice (1-3): ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline

        // Step 4: Validate subject selection
        if (choice < 1 || choice > subjects.size()) {
            System.out.println("Invalid subject choice. Exiting...");
        }

        String selectedSubject = subjects.get(choice - 1);
        System.out.println("\n You selected: " + selectedSubject);
        System.out.println("Answer the following questions:");

        // Step 5: Start quiz
        List<String> questions = Question.getQuestions(selectedSubject);
        List<Map<Character, String>> optionList = Question.getOptions(selectedSubject);
        List<String> userAnswers = new ArrayList<>();

        for (int i = 0; i < optionList.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ": " + questions.get(i));
            Map<Character, String> options = optionList.get(i);
            for (Map.Entry<Character, String> entry : options.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

            String answer = "";
            while (true) {
                System.out.print("Your answer (a/b/c/d): ");
                answer = sc.nextLine().trim().toLowerCase();
                if (answer.matches("[abcd]"))
                    break;
                System.out.println(" Please enter only a, b, c, or d.");
            }

            userAnswers.add(answer);
        }

        // Step 6: Evaluate and show result
        int score = Evaluation.evaluate(userAnswers, Question.getCorrectAnswers(selectedSubject));

        System.out.println("\n Exam Result");
        System.out.println("Student: " + name);
        System.out.println("Roll No: " + roll);
        System.out.println("Subject: " + selectedSubject);
        System.out.println("Score: " + score + " / " + 10);

        sc.close();
    }
}
