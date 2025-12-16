package controller;

import service.QuizzService;
import model.Question;
import model.Quizz;

public class quizzcontroller {

    private final QuizzService quizzService;

    public quizzcontroller(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    public Quizz createQuizz(String title) {
        return quizzService.createQuizz(title);
    }

    public void addQuestion(int quizzId, Question question) {
        quizzService.addQuestion(quizzId, question);
    }
}
