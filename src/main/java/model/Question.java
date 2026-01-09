package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Quiz question with multiple options.
 */
public class Question {

    private final String prompt;
    private final List<String> options;
    private final String correctAnswer;

    public Question(String prompt, List<String> options, String correctAnswer) {
        this.prompt = prompt;
        this.options = new ArrayList<>(options);
        this.correctAnswer = correctAnswer;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<String> getOptions() {
        return Collections.unmodifiableList(options);
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
