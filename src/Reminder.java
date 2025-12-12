import java.util.Date;

public class Reminder {
    private int id;
    private int studentId;
    private String text;
    private Date remindAt;

    public Reminder(int id, int studentId, String text, Date remindAt) {
        this.id = id;
        this.studentId = studentId;
        this.text = text;
        this.remindAt = remindAt;
    }

    public void markDone() {}
}
