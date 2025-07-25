import java.util.*;

class Question<T> {
    String text;
    String difficulty;
    Map<Character, T> options;
    T correctAnswer;

    public Question(String text, String difficulty, Map<Character, T> options, T correctAnswer) {
        this.text = text;
        this.difficulty = difficulty;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(T answer) {
        return correctAnswer.equals(answer);
    }
}

class Subject<T> {
    String name;
    List<Question<T>> questions;

    public Subject(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question<T> question) {
        questions.add(question);
    }
}

class Student<T> {
    String name;
    String rollNumber;
    Map<String, List<T>> submittedAnswers;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.submittedAnswers = new HashMap<>();
    }

    public void submitAnswer(String subjectName, List<T> answers) {
        submittedAnswers.put(subjectName, answers);
    }

    public int calculateScore(Subject<T> subject) {
        List<T> answers = submittedAnswers.get(subject.name);
        int score = 0;
        for (int i = 0; i < subject.questions.size(); i++) {
            if (i < answers.size() && subject.questions.get(i).isCorrect(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}

public class OnlineExamSystem {
    public static void main(String[] args) {
        Subject<String> javaSubject = new Subject<>("Java");

        Map<Character, String> options1 = new HashMap<>();
        options1.put('A', "Class");
        options1.put('B', "Object");
        options1.put('C', "Constructor");
        options1.put('D', "Interface");

        javaSubject.addQuestion(new Question<>(
                "Which keyword is used to define a class in Java?", "EASY", options1, "Class"));

        Map<Character, String> options2 = new HashMap<>();
        options2.put('A', "extends");
        options2.put('B', "implements");
        options2.put('C', "inherits");
        options2.put('D', "new");

        javaSubject.addQuestion(new Question<>(
                "Which keyword is used for inheritance in Java?", "MEDIUM", options2, "extends"));

        Student<String> student = new Student<>("Nishant", "2315990041");
        List<String> submittedAnswers = Arrays.asList("Class", "implements");
        student.submitAnswer("Java", submittedAnswers);

        int score = student.calculateScore(javaSubject);
        System.out.println("Student: " + student.name);
        System.out.println("Score in Java: " + score + "/" + javaSubject.questions.size());
    }
}
