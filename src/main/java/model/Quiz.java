package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Quiz tied to a topic.
 */
public class Quiz {

    private final int id;
    private final int topicId;
    private final String title;
    private final List<Question> questions = new ArrayList<>();

    public Quiz(int id, int topicId, String title) {
        this.id = id;
        this.topicId = topicId;
        this.title = title;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public int getId() {
        return id;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }
}
