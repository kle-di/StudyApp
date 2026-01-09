package model;

/**
 * Topic within a course.
 */
public class Topic {

    private final int id;
    private final int courseId;
    private final String title;
    private final String description;

    public Topic(int id, int courseId, String title, String description) {
        this.id = id;
        this.courseId = courseId;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
