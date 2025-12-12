import java.util.Date;

public class ChatMessage {
    private int id;
    private String text;
    private int authorId;
    private Date timestamp;

    public ChatMessage(int id, String text, int authorId, Date timestamp) {
        this.id = id;
        this.text = text;
        this.authorId = authorId;
        this.timestamp = timestamp;
    }
}

