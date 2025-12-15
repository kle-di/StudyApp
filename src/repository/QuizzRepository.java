package repository;

import model.Quizz;

import java.util.ArrayList;
import java.util.List;

public class QuizzRepository {
    private final List<Quizz> quizzes = new ArrayList<>();

    public void add(Quizz quizz) {
        quizzes.add(quizz);
    }

    public List<Quizz> findAll() {
        return quizzes;
    }

    public Quizz findById(int id) {
        for (Quizz q : quizzes) {
            if (q.getId() == id) return q;
        }
        return null;
    }
}
