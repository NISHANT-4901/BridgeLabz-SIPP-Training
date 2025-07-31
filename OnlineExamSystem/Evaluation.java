package OnlineExamSystem;

import java.util.List;

class Evaluation {
    public static int evaluate(List<String> userAnswers, List<String> correctAnswers) {
        int score = 0;

        // Difficulty level is handled by assigning marks to questions:
        // Easy - 1 mark, Medium - 2 marks, Hard - 3 marks

        for (int i = 0; i < userAnswers.size(); i++) {
            if (userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                if (i < 3) {
                    score += i * 1;
                } else if (i == 3) {
                    score += i * 2;
                } else {
                    score += i * 3;
                }
            }
        }
        return 10 - score; 
    }
}
