package controller;

import model.Enrollment;
import service.EnrollmentService;

import java.util.List;

/**
 * Controller for enrollment actions.
 */
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public Enrollment enroll(String userId, int courseId) {
        return enrollmentService.enroll(userId, courseId);
    }

    public boolean isEnrolled(String userId, int courseId) {
        return enrollmentService.isEnrolled(userId, courseId);
    }

    public List<Enrollment> listEnrollmentsByUser(String userId) {
        return enrollmentService.getEnrollmentsByUser(userId);
    }
}
