package model;

/**
 * Learning material for a topic.
 */
public class Material {

    private final int id;
    private final int topicId;
    private final MaterialType type;
    private final String title;
    private final String content;

    public Material(int id, int topicId, MaterialType type, String title, String content) {
        this.id = id;
        this.topicId = topicId;
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getTopicId() {
        return topicId;
    }

    public MaterialType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
