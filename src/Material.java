import java.util.Date;

public class Material {
    private int id;
    private String title;
    private String url;
    private Date uploadedAt;

    public Material(int id, String title, String url, Date uploadedAt) {
        this.id = id;
        this.title = title;
        this.url = url;
        this.uploadedAt = uploadedAt;
    }
}
