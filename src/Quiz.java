public class Quiz {
    private int id;
    private String title;
    private int ownerId;

    public Quiz(int id, String title, int ownerId) {
        this.id = id;
        this.title = title;
        this.ownerId = ownerId;
    }

    public void addQuestion(QuizQuestion question) {}
}

