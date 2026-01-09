package controller;

import model.Quiz;
import service.QuizService;

import java.util.List;

/**
 * Controller for quiz actions.
 */
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    public List<Quiz> listQuizzesByTopic(int topicId) {
        return quizService.getQuizzesByTopic(topicId);
    }
}
