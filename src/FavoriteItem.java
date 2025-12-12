public class FavoriteItem {
    private int id;
    private int studentId;
    private String itemType; // Material, Video, Deck, Quiz
    private int itemId;

    public FavoriteItem(int id, int studentId, String itemType, int itemId) {
        this.id = id;
        this.studentId = studentId;
        this.itemType = itemType;
        this.itemId = itemId;
    }
}

