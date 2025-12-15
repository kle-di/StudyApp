package model;

public class StudyProgress {

    private String userId;
    private int flashcardsStudied;
    private int quizzesCompleted;

    public StudyProgress(String userId) {
        this.userId = userId;
        this.flashcardsStudied = 0;
        this.quizzesCompleted = 0;
    }

    public void addFlashcards(int count) {
        this.flashcardsStudied += count;
    }

    public void incrementQuizzes() {
        this.quizzesCompleted++;
    }

    public int getFlashcardsStudied() {
        return flashcardsStudied;
    }

    public int getQuizzesCompleted() {
        return quizzesCompleted;
    }
}
