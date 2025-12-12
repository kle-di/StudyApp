public class Student {
    private int id;
    private String name;
    private String email;
    private String password;

    public Student(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public void register() {}
    public void login() {}
    public void updateProfile() {}
    public void joinGroup(int groupId) {}
    public void createGroup(String name) {}
    public void uploadMaterial(Material material) {}
    public void uploadVideo(Video video) {}
    public void createFlashcardDeck(String title) {}
    public void createQuiz(String title) {}
    public void saveFavorite(int itemId, String type) {}
    public void addReminder(String text, String date) {}
    public void search(String query) {}
}

