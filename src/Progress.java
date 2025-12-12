public class Progress {
    private int id;
    private int studentId;
    private int materialsViewed;
    private int videosViewed;
    private int flashcardsLearned;
    private int quizzesCompleted;

    public Progress(int id, int studentId, int materialsViewed, int videosViewed,
                    int flashcardsLearned, int quizzesCompleted) {
        this.id = id;
        this.studentId = studentId;
        this.materialsViewed = materialsViewed;
        this.videosViewed = videosViewed;
        this.flashcardsLearned = flashcardsLearned;
        this.quizzesCompleted = quizzesCompleted;
    }

    public void updateProgress(String type) {}
}

