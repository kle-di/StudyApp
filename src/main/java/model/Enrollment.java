package model;

/**
 * Enrollment that links a user to a course.
 */
public class Enrollment {

    private final int id;
    private final String userId;
    private final int courseId;
    private final String enrolledAt;

    public Enrollment(int id, String userId, int courseId, String enrolledAt) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.enrolledAt = enrolledAt;
    }

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getEnrolledAt() {
        return enrolledAt;
    }
}
