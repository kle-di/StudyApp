package repository;

import model.Question;
import model.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In-memory repository for quizzes.
 */
public class QuizRepository {

    private final List<Quiz> quizzes = new ArrayList<>();

    public QuizRepository() {
        Quiz javaQuiz = new Quiz(1, 101, "Java Basics");
        javaQuiz.addQuestion(new Question(
                "Which data type stores a whole number?",
                Arrays.asList("int", "double", "boolean"),
                "int"));
        javaQuiz.addQuestion(new Question(
                "What keyword starts a loop with a known count?",
                Arrays.asList("for", "while", "switch"),
                "for"));
        quizzes.add(javaQuiz);

        Quiz historyQuiz = new Quiz(2, 201, "Ancient Civilizations");
        historyQuiz.addQuestion(new Question(
                "Which civilization built pyramids?",
                Arrays.asList("Ancient Egypt", "Ancient Rome", "Vikings"),
                "Ancient Egypt"));
        quizzes.add(historyQuiz);

        Quiz structuresQuiz = new Quiz(3, 301, "Arrays and Lists");
        structuresQuiz.addQuestion(new Question(
                "What is the first index in an array?",
                Arrays.asList("0", "1", "-1"),
                "0"));
        quizzes.add(structuresQuiz);
    }

    public List<Quiz> findByTopicId(int topicId) {
        List<Quiz> results = new ArrayList<>();
        for (Quiz quiz : quizzes) {
            if (quiz.getTopicId() == topicId) {
                results.add(quiz);
            }
        }
        return results;
    }
}
