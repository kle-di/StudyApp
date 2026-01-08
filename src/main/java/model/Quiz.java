package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Quiz composed of questions.
 */
public class Quiz implements Iterable<Question> {

    private final int id;
    private final String title;
    private final List<Question> questions = new ArrayList<>();

    public Quiz(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public Iterator<Question> iterator() {
        return new QuestionIterator();
    }

    private final class QuestionIterator implements Iterator<Question> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < questions.size();
        }

        @Override
        public Question next() {
            return questions.get(index++);
        }
    }
}
