package model;

import java.util.ArrayList;
import java.util.List;

public class Quizz {
    private int id;
    private String title;
    private List<Question> questions = new ArrayList<>();

    public Quizz(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
}
