package model;

public class Question {
    private String text;
    private String correctAnswer;

    public Question(String text, String correctAnswer) {
        this.text = text;
        this.correctAnswer = correctAnswer;
    }

    public String getText() { return text; }
    public String getCorrectAnswer() { return correctAnswer; }
}
