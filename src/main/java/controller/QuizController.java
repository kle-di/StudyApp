package controller;

import model.Question;
import model.Quiz;
import service.QuizService;

/**
 * Controller for quiz actions.
 */
public class QuizController {

    private final QuizService QuizService;

    public QuizController(QuizService QuizService) {
        this.QuizService = QuizService;
    }

    public Quiz createQuiz(String title) {
        return QuizService.createQuiz(title);
    }

    public void addQuestion(int QuizId, Question question) {
        QuizService.addQuestion(QuizId, question);
    }
}
