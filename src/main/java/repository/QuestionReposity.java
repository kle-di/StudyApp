package repository;

import model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionReposity {

    private final List<Question> questions = new ArrayList<>();

    public void add(Question question) {
        questions.add(question);
    }

    public List<Question> findAll() {
        return questions;
    }

    public Question findByIndex(int index) {
        if (index < 0 || index >= questions.size()) {
            return null;
        }
        return questions.get(index);
    }

    public int size() {
        return questions.size();
    }
}
