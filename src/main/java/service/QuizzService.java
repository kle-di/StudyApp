// service/QuizzService.java
package service;

import model.Question;
import model.Quizz;
import repository.QuizzRepository;

import java.util.List;

public class QuizzService {

    private final QuizzRepository quizzRepository;
    private int nextQuizzId = 1;

    public QuizzService(QuizzRepository quizzRepository) {
        this.quizzRepository = quizzRepository;
    }

    public Quizz createQuizz(String title) {
        Quizz quizz = new Quizz(nextQuizzId++, title);
        quizzRepository.add(quizz);
        return quizz;
    }

    public void addQuestion(int quizzId, Question question) {
        Quizz q = quizzRepository.findById(quizzId);
        if (q == null) throw new IllegalArgumentException("Quizz not found");
        q.addQuestion(question);
    }

    public List<Quizz> listAll() {
        return quizzRepository.findAll();
    }
}
