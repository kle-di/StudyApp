package repository;

import model.Enrollment;
import util.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for enrollments.
 */
public class EnrollmentRepository {

    private final List<Enrollment> enrollments = new ArrayList<>();
    private int nextId = 1;

    public Enrollment enroll(String userId, int courseId) {
        Enrollment existing = findByUserAndCourse(userId, courseId);
        if (existing != null) {
            return existing;
        }
        Enrollment enrollment = new Enrollment(nextId++, userId, courseId, DateUtils.nowAsString());
        enrollments.add(enrollment);
        return enrollment;
    }

    public boolean isEnrolled(String userId, int courseId) {
        return findByUserAndCourse(userId, courseId) != null;
    }

    public List<Enrollment> findByUserId(String userId) {
        List<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getUserId().equals(userId)) {
                results.add(enrollment);
            }
        }
        return results;
    }

    private Enrollment findByUserAndCourse(String userId, int courseId) {
        for (Enrollment enrollment : enrollments) {
            if (enrollment.getUserId().equals(userId) && enrollment.getCourseId() == courseId) {
                return enrollment;
            }
        }
        return null;
    }
}
