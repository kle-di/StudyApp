package model;

/**
 * Tracks learning progress for a user.
 */
public class Progress {

    private final String userId;
    private int topicsVisited;
    private int flashcardsReviewed;
    private int quizzesTaken;
    private int correctAnswers;

    public Progress(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public int getTopicsVisited() {
        return topicsVisited;
    }

    public int getFlashcardsReviewed() {
        return flashcardsReviewed;
    }

    public int getQuizzesTaken() {
        return quizzesTaken;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void recordTopicVisit() {
        topicsVisited++;
    }

    public void addFlashcardsReviewed(int count) {
        if (count > 0) {
            flashcardsReviewed += count;
        }
    }

    public void recordQuizResult(int correct, int total) {
        if (total <= 0) {
            return;
        }
        quizzesTaken++;
        int safeCorrect = Math.max(0, Math.min(correct, total));
        correctAnswers += safeCorrect;
    }
}
