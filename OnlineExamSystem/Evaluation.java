package OnlineExamSystem;

import java.util.List;

class Evaluation {
    public static int evaluate(List<String> userAnswers, List<String> correctAnswers) {
        int score = 0;
        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
