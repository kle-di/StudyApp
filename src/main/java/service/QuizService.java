package service;

import model.Quiz;
import repository.QuizRepository;

import java.util.List;

/**
 * Quiz operations over the repository.
 */
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getQuizzesByTopic(int topicId) {
        return quizRepository.findByTopicId(topicId);
    }
}
