import java.util.Date;

public class Video {
    private int id;
    private String title;
    private String url;
    private int durationSec;
    private Date uploadedAt;

    public Video(int id, String title, String url, int durationSec, Date uploadedAt) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.durationSec = durationSec;
        this.uploadedAt = uploadedAt;
    }
}
