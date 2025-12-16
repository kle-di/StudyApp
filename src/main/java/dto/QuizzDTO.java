package dto;

public class QuizzDTO {

    private int id;
    private String title;

    public QuizzDTO(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
