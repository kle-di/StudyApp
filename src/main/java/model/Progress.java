package model;

/**
 * Tracks study progress for a user.
 */
public class Progress {

    private final String userId;
    private int flashcardsStudied;
    private int QuizesCompleted;

    public Progress(String userId) {
        this.userId = userId;
        this.flashcardsStudied = 0;
        this.QuizesCompleted = 0;
    }

    public void addFlashcards(int count) {
        this.flashcardsStudied += count;
    }

    public void incrementQuizes() {
        this.QuizesCompleted++;
    }

    public String getUserId() {
        return userId;
    }

    public int getFlashcardsStudied() {
        return flashcardsStudied;
    }

    public int getQuizesCompleted() {
        return QuizesCompleted;
    }
}
